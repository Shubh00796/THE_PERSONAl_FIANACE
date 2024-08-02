package com.personalfinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.dto.AskForHelpDTO;
import com.personalfinance.entites.AskForHelp;
import com.personalfinance.service.AskforHelpservice;

@RestController
@RequestMapping("/api/ask-for-help")
public class AskForHelpController {

    @Autowired
    private AskforHelpservice askforhelpservice;

    @PostMapping
    public ResponseEntity<AskForHelp> createAskForHelp(@RequestBody AskForHelpDTO askhelpdto) {
        try {
            AskForHelp createdAskForHelp = askforhelpservice.createAskForHelp(askhelpdto);
            return new ResponseEntity<>(createdAskForHelp, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
