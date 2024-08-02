package com.personalfinance.entites;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component

public class AskForHelp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String askTheExpert;
    private String timeToTalkToExpert;
    private String concern;
    private String email; 

    public AskForHelp() {}

    public AskForHelp(String askTheExpert, String timeToTalkToExpert, String concern, String email) {
        this.askTheExpert = askTheExpert;
        this.timeToTalkToExpert = timeToTalkToExpert;
        this.concern = concern;	
        this.email = email;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAskTheExpert() {
        return askTheExpert;
    }

    public void setAskTheExpert(String askTheExpert) {
        this.askTheExpert = askTheExpert;
    }

    public String getTimeToTalkToExpert() {
        return timeToTalkToExpert;
    }

    public void setTimeToTalkToExpert(String timeToTalkToExpert) {
        this.timeToTalkToExpert = timeToTalkToExpert;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
