package com.personalfinance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.personalfinance.entites.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
