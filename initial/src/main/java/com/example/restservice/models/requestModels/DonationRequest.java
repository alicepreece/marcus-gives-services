package com.example.restservice.models.requestModels;

import org.springframework.lang.Nullable;

import java.util.Objects;

public class DonationRequest {
    Integer clientId;
    Integer projectId;
    Integer amount;
    Integer timestamp;

    DonationRequest() {}

    DonationRequest(Integer clientId, Integer projectId, Integer amount, Integer timestamp) {
        this.clientId = clientId;
        this.projectId = projectId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClient(Integer client) {
        this.clientId = clientId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonationRequest that = (DonationRequest) o;
        return timestamp == that.timestamp &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, projectId, amount, timestamp);
    }

    @Override
    public String toString() {
        return "DonationRequest{" +
                "amount='" + amount + '\'' +
                ", client=" + clientId +
                ", projectId=" + projectId +
                ", timestamp=" + timestamp +
                '}';
    }
}
