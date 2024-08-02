package com.personalfinance.dto;


public class AskForHelpDTO {
    private String askTheExpert;
    private String timeToTalkToExpert;
    private String concern;
    private String email;

    public AskForHelpDTO() {}

	public String getAskTheExpert() {
		return askTheExpert;
	}

	public void setAskTheExpert(String askTheExpert) {
		this.askTheExpert = askTheExpert;
	}

	public String getTimeToTalkToExpert() {
		return timeToTalkToExpert;
	}

	public void setTimeToTalkToExpert(String timeToTalkToExpert) {
		this.timeToTalkToExpert = timeToTalkToExpert;
	}

	public String getConcern() {
		return concern;
	}

	public void setConcern(String concern) {
		this.concern = concern;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    

}