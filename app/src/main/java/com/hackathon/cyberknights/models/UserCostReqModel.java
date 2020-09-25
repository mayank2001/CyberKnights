package com.hackathon.cyberknights.models;

public class UserCostReqModel {
    String username;

    public UserCostReqModel(String username, String monthlyIncome, String dob) {
        this.username = username;
        this.monthlyIncome = monthlyIncome;
        this.dob = dob;
    }

    String monthlyIncome;
    String dob;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
