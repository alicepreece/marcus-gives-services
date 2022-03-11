package com.example.restservice.models;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.List;
import java.util.Objects;

public class Client {
    @BsonRepresentation(BsonType.OBJECT_ID)
    public String _id;
    private int id;
    private User user;
    private String emailAddress;
    private int accountNumber;
    private String recommendation;
    private List<Integer> projects;
    private List<Integer> pastProjects;
    private int investableAmount;
    private String advisorTeam;
    private Scores scores;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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

    public String getAdvisorTeam() {
        return advisorTeam;
    }

    public void setAdvisorTeam(String advisorTeam) {
        this.advisorTeam = advisorTeam;
    }

    public Scores getScores() { return scores; }

    public void setScores(Scores scores) { this.scores = scores; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                accountNumber == client.accountNumber &&
                investableAmount == client.investableAmount &&
                Objects.equals(user, client.user) &&
                Objects.equals(emailAddress, client.emailAddress) &&
                Objects.equals(recommendation, client.recommendation) &&
                Objects.equals(advisorTeam, client.advisorTeam) &&
                Objects.equals(projects, client.projects) &&
                Objects.equals(pastProjects, client.pastProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, emailAddress, accountNumber, recommendation, projects, pastProjects, investableAmount, advisorTeam);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", user=" + user +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountNumber=" + accountNumber +
                ", recommendation='" + recommendation + '\'' +
                ", projects=" + projects +
                ", pastProjects=" + pastProjects +
                ", investableAmount=" + investableAmount +
                ", advisorTeam=" + advisorTeam +
                '}';
    }
}