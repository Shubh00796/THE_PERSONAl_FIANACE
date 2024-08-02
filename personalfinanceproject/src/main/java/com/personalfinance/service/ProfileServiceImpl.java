package com.personalfinance.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.personalfinance.dao.ProfileRepo;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.ProfileDTO;
import com.personalfinance.entites.Profile;
import com.personalfinance.entites.User;
import java.util.Base64;

@Service
public class ProfileServiceImpl implements Profileservice {

    @Autowired
    private UserDao userRepo;

    @Autowired
    private ProfileRepo profilerepo;

    @Override
    public Profile createProfile(ProfileDTO profiledto) {
    	System.out.println("GET EMAIL ID " + profiledto.getUserEmail());
    	  User user = userRepo.findByEmail(profiledto.getUserEmail());
    	  
    	    if (user == null) {
    	        throw new RuntimeException("User not found for email: " + profiledto.getUserEmail());
    	        // Alternatively, you can return null or handle this case based on your application's logic
    	    }
        Profile profile = new Profile();
        profile.setBio(profiledto.getBio());
        profile.setCity(profiledto.getCity());
        profile.setCountry(profiledto.getCountry());
        profile.setDateOfBirth(profiledto.getDateOfBirth());
        profile.setGender(profiledto.getGender());
        profile.setOccupation(profiledto.getOccupation());
        profile.setPhoneNumber(profiledto.getPhoneNumber());
        profile.setProfilePictureUrl(profiledto.getProfilePictureUrl());
        profile.setState(profiledto.getState());
        profile.setStreet(profiledto.getStreet());
        profile.setZipCode(profiledto.getZipCode());
        profile.setUser(user);
        

        return profilerepo.save(profile);
    }
}
