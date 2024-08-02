package com.personalfinance.dto;


import java.util.Date;

public class InsuranceClaimDTO {

    private Long id;
    private String policyNumber;
    private String claimantName;
    private Date doa;
    private Date dod;
    private String hospitalName;
    private String hospitalAddress;
    private Double claimAmount;
    private String claimStatus;
    private String userEmail;

    // Default constructor
    public InsuranceClaimDTO() {}

    // Parameterized constructor
    public InsuranceClaimDTO(Long id, String policyNumber, String claimantName, Date doa, Date dod, String hospitalName,
                             String hospitalAddress, Double claimAmount, String claimStatus, String userEmail) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.claimantName = claimantName;
        this.doa = doa;
        this.dod = dod;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.claimAmount = claimAmount;
        this.claimStatus = claimStatus;
        this.userEmail = userEmail;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public Date getDoa() {
        return doa;
    }

    public void setDoa(Date doa) {
        this.doa = doa;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "InsuranceClaimDTO{" +
                "id=" + id +
                ", policyNumber='" + policyNumber + '\'' +
                ", claimantName='" + claimantName + '\'' +
                ", doa=" + doa +
                ", dod=" + dod +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                ", claimAmount=" + claimAmount +
                ", claimStatus='" + claimStatus + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
