package com.personalfinance.service;

import com.personalfinance.dto.ProfileDTO;
import com.personalfinance.entites.Profile;

public interface Profileservice {
	
	Profile createProfile(ProfileDTO profiledto);

}
