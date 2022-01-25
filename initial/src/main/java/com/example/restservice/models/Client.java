package com.example.restservice.models;

import java.util.ArrayList;

public class Client {
    private int id;
    private String firstName;
    private String surname;
    private String emailAddress;
    private int accountNumber;
    private String preferences;
    private ArrayList<Project> projects;
    private ArrayList<Project> pastProjects;
    private int investableAmount;


    public Client(int id, String firstName, String surname) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getPastProjects() {
        return pastProjects;
    }

    public void setPastProjects(ArrayList<Project> pastProjects) {
        this.pastProjects = pastProjects;
    }

    public int getInvestableAmount() {
        return investableAmount;
    }

    public void setInvestableAmount(int investableAmount) {
        this.investableAmount = investableAmount;
    }
}
