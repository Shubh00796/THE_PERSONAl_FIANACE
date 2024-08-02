package com.personalfinance.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.dto.ProfileDTO;
import com.personalfinance.entites.Profile;
import com.personalfinance.service.Profileservice;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class ProfileController {

@Autowired
private Profileservice profileservice;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDTO profileDTO) {
        try {
            Profile createdProfile = profileservice.createProfile(profileDTO);
            return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}