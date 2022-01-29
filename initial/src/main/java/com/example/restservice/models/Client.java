package com.example.restservice.models;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.List;
import java.util.Objects;

public class Client {
    @BsonRepresentation(BsonType.OBJECT_ID)
    public String _id;
    private int id;
    private String firstName;
    private String surname;
    private String emailAddress;
    private int accountNumber;
    private String preferences;
    private List<Integer> projects;
    private List<Integer> pastProjects;
    private int investableAmount;

    public Client() {
    }

    public Client(int id, String firstName, String surname, String emailAddress, int accountNumber, String preferences, List<Integer> projects, List<Integer> pastProjects, int investableAmount) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.accountNumber = accountNumber;
        this.preferences = preferences;
        this.projects = projects;
        this.pastProjects = pastProjects;
        this.investableAmount = investableAmount;
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

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public List<Integer> getProjects() {
        return projects;
    }

    public void setProjects(List<Integer> projects) {
        this.projects = projects;
    }

    public List<Integer> getPastProjects() {
        return pastProjects;
    }

    public void setPastProjects(List<Integer> pastProjects) {
        this.pastProjects = pastProjects;
    }

    public int getInvestableAmount() {
        return investableAmount;
    }

    public void setInvestableAmount(int investableAmount) {
        this.investableAmount = investableAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                accountNumber == client.accountNumber &&
                investableAmount == client.investableAmount &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(emailAddress, client.emailAddress) &&
                Objects.equals(preferences, client.preferences) &&
                Objects.equals(projects, client.projects) &&
                Objects.equals(pastProjects, client.pastProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname, emailAddress, accountNumber, preferences, projects, pastProjects, investableAmount);
    }

    @Override
    public String toString() {
        return "Client{" +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountNumber=" + accountNumber +
                ", preferences='" + preferences + '\'' +
                ", projects=" + projects +
                ", pastProjects=" + pastProjects +
                ", investableAmount=" + investableAmount +
                '}';
    }
}