package com.personalfinance.dto;

import java.time.LocalDate;

public class ProfileDTO {
    private Long id;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String profilePictureUrl;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String bio;
    private String occupation;
    private String gender;
    private String userEmail;

    public ProfileDTO() {
        super();
    }

    public ProfileDTO(Long id, String phoneNumber, LocalDate dateOfBirth, String profilePictureUrl, String street,
                      String city, String state, String zipCode, String country, String bio, String occupation, String gender,
                      String userEmail) {
        super();
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.profilePictureUrl = profilePictureUrl;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.bio = bio;
        this.occupation = occupation;
        this.gender = gender;
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        System.out.println("Setting bio: " + bio);
        this.bio = bio;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        System.out.println("Setting occupation: " + occupation);
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        System.out.println("Setting gender: " + gender);
        this.gender = gender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
