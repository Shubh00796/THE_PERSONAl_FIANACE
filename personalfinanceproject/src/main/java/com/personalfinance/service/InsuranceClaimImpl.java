package com.personalfinance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.InsuranceClaimRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.InsuranceClaimDTO;
import com.personalfinance.entites.InsuranceClaim;
import com.personalfinance.entites.User;
@Service
public class InsuranceClaimImpl implements Insuranceservice{
	
	@Autowired 
	private UserDao userRepo;
	
	@Autowired
	private InsuranceClaimRepository insurepo;
	
	
	@Override
	public InsuranceClaim createClaim(InsuranceClaimDTO insurancedto) {
		User user = userRepo.findByEmail(insurancedto.getUserEmail());
		
		if(user == null) {
			throw new RuntimeException("User not found Exception ");
		}
		
		InsuranceClaim insurance = new InsuranceClaim();
		
		insurance.setClaimAmount(insurancedto.getClaimAmount());
		insurance.setClaimantName(insurancedto.getClaimantName());
		insurance.setClaimStatus(insurancedto.getClaimStatus());
		insurance.setDoa(insurancedto.getDoa());
		insurance.setDod(insurancedto.getDod());
		insurance.setHospitalAddress(insurancedto.getHospitalAddress());
		insurance.setHospitalName(insurancedto.getHospitalName());
		insurance.setPolicyNumber(insurancedto.getPolicyNumber());
		insurance.setUser(user);
		
		System.out.println("INSURANCE" + 	insurancedto.getClaimantName());
		
        return insurepo.save(insurance);

	}
	
	
	public List<InsuranceClaimDTO> getInsuranceByEmail(String Email){
		List<InsuranceClaim> claim = insurepo.findByUserEmail(Email);
		
		if(claim.isEmpty()) {
			throw new IllegalArgumentException("Insurance not found for the user" + Email);
		}
		
		List<InsuranceClaimDTO> claimdto = new ArrayList<>();
		
		for(InsuranceClaim  insuranceclaim : claim) {
			InsuranceClaimDTO dto = new InsuranceClaimDTO();
			dto.setClaimAmount(insuranceclaim.getClaimAmount());
			dto.setClaimantName(insuranceclaim.getClaimantName());
			dto.setClaimStatus(insuranceclaim.getClaimStatus());
			dto.setDoa(insuranceclaim.getDoa());
			dto.setDod(insuranceclaim.getDod());
			dto.setHospitalAddress(insuranceclaim.getHospitalAddress());
			dto.setHospitalName(insuranceclaim.getHospitalName());
			dto.setPolicyNumber(insuranceclaim.getPolicyNumber());
			claimdto.add(dto);
			
			
		}
		return claimdto;
	}
	
	


}
