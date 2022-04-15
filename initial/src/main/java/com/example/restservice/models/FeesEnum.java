package com.example.restservice.models;

public enum FeesEnum {
    NONE("NONE"),
    UNDER5("UNDER5"),
    OVER5("OVER5");

    private String fees;

    FeesEnum(String fees) {
        this.fees = fees;
    }

    public String getFees() {
        return fees;
    }
}
