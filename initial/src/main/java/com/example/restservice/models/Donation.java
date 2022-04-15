package com.example.restservice.models;

import java.util.Objects;

public class Donation {
    Project project;
    int amount;
    int timestamp;


    public Donation(){}

    public Donation(Project project, int amount, int timestamp) {
        this.amount = amount;
        this.project = project;
        this.timestamp = timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return amount == donation.amount &&
                project == donation.project &&
                timestamp == donation.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, amount, timestamp);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "projectId=" + project +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
