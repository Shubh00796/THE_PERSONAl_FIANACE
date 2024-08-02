package com.personalfinance.service;

import java.util.List;

import com.personalfinance.dto.InsuranceClaimDTO;
import com.personalfinance.entites.InsuranceClaim;

public interface Insuranceservice {
	
	InsuranceClaim createClaim( InsuranceClaimDTO insurancedto);
	 List<InsuranceClaimDTO> getInsuranceByEmail(String Email);

}
