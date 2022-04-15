package com.example.restservice.models;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.Objects;

public class Advisor {
    @BsonRepresentation(BsonType.OBJECT_ID)
    public String _id;
    private int id;
    private User user;
    private String team;

    public Advisor(){}

    public Advisor(int id, User user, String team) {
        this.id = id;
        this.user = user;
        this.team = team;
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
        return id == advisor.id &&
                Objects.equals(user, advisor.user) &&
                Objects.equals(team, advisor.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, team);
    }

    @Override
    public String toString() {
        return "Advisor{" +
                "userId=" + id +
                ", user=" + user +
                ", team='" + team + '\'' +
                '}';
    }
}
