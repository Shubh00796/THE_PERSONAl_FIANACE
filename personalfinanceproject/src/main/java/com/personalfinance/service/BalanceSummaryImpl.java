package com.personalfinance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.BalanceSummaryRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.BalanceSummaryDTO;
import com.personalfinance.entites.BalanceSummary;
import com.personalfinance.entites.User;

@Service
public class BalanceSummaryImpl implements BalanceSumary {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private BalanceSummaryRepository balanceSummaryRepository;

    @Override
    public BalanceSummaryDTO createReport(BalanceSummaryDTO balanceSummaryDto) {
        User user = userRepository.findByEmail(balanceSummaryDto.getUserEmail());

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }	

        // Convert DTO to entity
        BalanceSummary balanceSummary = new BalanceSummary();
        balanceSummary.setUser(user);
        balanceSummary.setMaxAmountToBeSpend(balanceSummaryDto.getMaxAmountToBeSpend());
        balanceSummary.setEnterTheBalanceYouWantToAdd(balanceSummaryDto.getEnterTheBalanceYouWantToAdd());
        balanceSummary.setAmountToBeSaved(balanceSummaryDto.getAmountToBeSaved());

        // Save the entity to the database
        BalanceSummary savedBalanceSummary = balanceSummaryRepository.save(balanceSummary);
		return balanceSummaryDto;

        // Convert the saved entity back to DTO
//        BalanceSummaryDTO savedBalanceSummaryDto = new BalanceSummaryDTO();
//        savedBalanceSummaryDto.setId(savedBalanceSummary.getId());
//        savedBalanceSummaryDto.setUserEmail(savedBalanceSummary.getUser().getEmail());
//        savedBalanceSummaryDto.setMaxAmountToBeSpend(savedBalanceSummary.getMaxAmountToBeSpend());
//        savedBalanceSummaryDto.setEnterTheBalanceYouWantToAdd(savedBalanceSummary.getEnterTheBalanceYouWantToAdd());
//        savedBalanceSummaryDto.setAmountToBeSaved(savedBalanceSummary.getAmountToBeSaved());
//
//        return savedBalanceSummaryDto;
    }
    @Override
    public List<BalanceSummaryDTO> getBalanceSummaryByUserEmail(String userEmail) {
        List<BalanceSummary> balanceSummaries = balanceSummaryRepository.findByUserEmail(userEmail);

        if (balanceSummaries.isEmpty()) {
            throw new IllegalArgumentException("Balance summary not found for user with email: " + userEmail);
        }

        List<BalanceSummaryDTO> balanceSummaryDTOs = new ArrayList<>();
        for (BalanceSummary balanceSummary : balanceSummaries) {
            BalanceSummaryDTO balanceSummaryDto = new BalanceSummaryDTO();
            balanceSummaryDto.setId(balanceSummary.getId());
            balanceSummaryDto.setUserEmail(balanceSummary.getUser().getEmail());
            balanceSummaryDto.setMaxAmountToBeSpend(balanceSummary.getMaxAmountToBeSpend());
            balanceSummaryDto.setEnterTheBalanceYouWantToAdd(balanceSummary.getEnterTheBalanceYouWantToAdd());
            balanceSummaryDto.setAmountToBeSaved(balanceSummary.getAmountToBeSaved());
            balanceSummaryDTOs.add(balanceSummaryDto);
        }

        return balanceSummaryDTOs;
    }



	}
