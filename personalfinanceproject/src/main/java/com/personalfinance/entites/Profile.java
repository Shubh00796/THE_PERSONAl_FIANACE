package com.personalfinance.entites;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Profile {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @Column(nullable = false)
	    private String phoneNumber;

	    @Temporal(TemporalType.DATE)
	    private LocalDate dateOfBirth;

	    
	    private String profilePictureUrl;

	    public Profile() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Profile [id=" + id + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth
					+ ", profilePictureUrl=" + profilePictureUrl + ", street=" + street + ", city=" + city + ", state="
					+ state + ", zipCode=" + zipCode + ", user=" + user + "]";
		}
		public Profile(Long id, String phoneNumber, LocalDate dateOfBirth, String profilePictureUrl, String street,
				String city, String state, String zipCode, User user) {
			super();
			this.id = id;
			this.phoneNumber = phoneNumber;
			this.dateOfBirth = dateOfBirth;
			this.profilePictureUrl = profilePictureUrl;
			this.street = street;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.user = user;
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
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		private String street;
	    private String city;
	    private String state;
	    private String zipCode;
	    private String bio;
	    private String occupation;
	    private String Gender;
	    private String country;
	    public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		@ManyToOne
	    @JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
	    @JsonBackReference
	    private User user;

		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		public Profile(Long id, String phoneNumber, LocalDate dateOfBirth, String profilePictureUrl, String street,
				String city, String state, String zipCode, String bio, String occupation, String gender, User user) {
			super();
			this.id = id;
			this.phoneNumber = phoneNumber;
			this.dateOfBirth = dateOfBirth;
			this.profilePictureUrl = profilePictureUrl;
			this.street = street;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.bio = bio;
			this.occupation = occupation;
			Gender = gender;
			this.user = user;
		}

	
}
