package com.personalfinance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.AskForHelpRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.AskForHelpDTO;
import com.personalfinance.entites.AskForHelp;
import com.personalfinance.entites.User;
@Service
public class AskforHelpImpl implements AskforHelpservice{
	
	
    @Autowired
    private AskForHelpRepository askforthehelp;
    
    @Autowired
    private AskForHelp help;     
    @Autowired 
	private UserDao userRepo;
	@Override
	public AskForHelp createAskForHelp(AskForHelpDTO askhelpdto) {		
		User user = userRepo.findByEmail(askhelpdto.getEmail());
	
		if(user == null) {
			throw new RuntimeException("User not found Exception ");
		}
		
		
		if(!isValidEmail(askhelpdto.getEmail())) {
            throw new RuntimeException("Invalid email format");

		}
		
//		AskForHelp help = new AskForHelp();
		
		// you can use the depdency injection for implemtiting or accesing the obj of ask for help class by simply autoering 
		//the given class
	
		help.setAskTheExpert(askhelpdto.getAskTheExpert());
		help.setConcern(askhelpdto.getConcern());
		help.setTimeToTalkToExpert(askhelpdto.getTimeToTalkToExpert());
		help.setEmail(askhelpdto.getEmail());



		return askforthehelp.save(help);
	}
	private boolean isValidEmail(String email) {
        // Simple email validation logic
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

}
