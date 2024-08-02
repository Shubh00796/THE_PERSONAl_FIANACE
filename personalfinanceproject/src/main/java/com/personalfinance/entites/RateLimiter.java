package com.personalfinance.entites;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class RateLimiter {
    private final int capacity = 3;
    private final long refillInterval = 30_000_000_000L; // 30secs in nanoseconds
    private final Map<Long, UserBucket> buckets = new ConcurrentHashMap<>();

    public boolean allowRequest(Long userId) {
        UserBucket bucket = buckets.computeIfAbsent(userId, k -> new UserBucket(capacity, refillInterval));
        return bucket.allowRequest();
    }

    private static class UserBucket {
        private final int capacity;
        private final long refillInterval;
        private AtomicInteger tokens;
        private AtomicLong lastRefillTimestamp;

        public UserBucket(int capacity, long refillInterval) {
            this.capacity = capacity;
            this.refillInterval = refillInterval;
            this.tokens = new AtomicInteger(capacity);
            this.lastRefillTimestamp = new AtomicLong(System.nanoTime());
        }

        public boolean allowRequest() {
            refillTokens();
            if (tokens.get() > 0) {
                tokens.decrementAndGet();
                return true;
            }
            return false;
        }

        private void refillTokens() {
            long now = System.nanoTime();
            long elapsedTime = now - lastRefillTimestamp.get();
            long tokensToAdd = elapsedTime / refillInterval;

            if (tokensToAdd > 0) {
                int newTokenCount = Math.min(capacity, tokens.addAndGet((int) tokensToAdd));
                tokens.set(newTokenCount);
                lastRefillTimestamp.addAndGet(tokensToAdd * refillInterval);
            }
        }
    }
}