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
    private List<Donation> donations;
    private List<Donation> pastDonations;
    private int investableAmount;
    private String advisorTeam;
    private Scores scores;

    public Client() {
    }

    public Client(int id, User user, String emailAddress, int accountNumber, String recommendation, List<Donation> donations, List<Donation> pastDonations, int investableAmount, String advisorTeam, Scores scores) {
        this.id = id;
        this.user = user;
        this.emailAddress = emailAddress;
        this.accountNumber = accountNumber;
        this.recommendation = recommendation;
        this.donations = donations;
        this.pastDonations = pastDonations;
        this.investableAmount = investableAmount;
        this.advisorTeam = advisorTeam;
        this.scores = scores;
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

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public List<Donation> getPastDonations() {
        return pastDonations;
    }

    public void setPastDonations(List<Donation> pastDonations) {
        this.pastDonations = pastDonations;
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
                Objects.equals(donations, client.donations) &&
                Objects.equals(pastDonations, client.pastDonations) &&
                Objects.equals(advisorTeam, client.advisorTeam) &&
                Objects.equals(scores, client.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, emailAddress, accountNumber, recommendation, donations, pastDonations, investableAmount, advisorTeam);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", user=" + user +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountNumber=" + accountNumber +
                ", recommendation='" + recommendation + '\'' +
                ", projects=" + donations +
                ", pastProjects=" + pastDonations +
                ", investableAmount=" + investableAmount +
                ", advisorTeam=" + advisorTeam +
                '}';
    }
}