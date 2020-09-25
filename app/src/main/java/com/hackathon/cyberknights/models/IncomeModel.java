package com.hackathon.cyberknights.models;

public class IncomeModel {

    String incomeFull;
    String spendLimit;
    String source;

    public IncomeModel(String incomeFull, String spendLimit, String source) {
        this.incomeFull = incomeFull;
        this.spendLimit = spendLimit;
        this.source = source;
    }

    public String getIncomeFull() {
        return incomeFull;
    }

    public void setIncomeFull(String incomeFull) {
        this.incomeFull = incomeFull;
    }

    public String getSpendLimit() {
        return spendLimit;
    }

    public void setSpendLimit(String spendLimit) {
        this.spendLimit = spendLimit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
