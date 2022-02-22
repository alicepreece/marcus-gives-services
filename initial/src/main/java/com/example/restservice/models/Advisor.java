package com.example.restservice.models;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.Objects;

public class Advisor {
    @BsonRepresentation(BsonType.OBJECT_ID)
    public String _id;
    private int userId;
    private User user;
    private String team;

    public Advisor(){}

    public Advisor(int id, User user, String team) {
        this.userId = id;
        this.user = user;
        this.team = team;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advisor advisor = (Advisor) o;
        return userId == advisor.userId &&
                Objects.equals(user, advisor.user) &&
                Objects.equals(team, advisor.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, user, team);
    }

    @Override
    public String toString() {
        return "Advisor{" +
                "userId=" + userId +
                ", user=" + user +
                ", team='" + team + '\'' +
                '}';
    }
}
