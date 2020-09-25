package com.hackathon.cyberknights.models;

public class ExpenseModel {
    String category,time,spentAmount;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(String spentAmount) {
        this.spentAmount = spentAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ExpenseModel(String category, String time, String spentAmount) {
        this.category = category;
        this.time = time;
        this.spentAmount = spentAmount;
    }
}
