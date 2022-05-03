package com.example.restservice.repositories;

import com.example.restservice.DBConnection;
import com.example.restservice.models.Advisor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdvisorRepository {
    private MongoCollection<Advisor> advisors;

    public AdvisorRepository() {
        MongoDatabase database = DBConnection.getDBConnection().getDatabase("marcus-gives");
        advisors = database.getCollection("advisors", Advisor.class);
    }

    public List<Advisor> getAdvisors() {
        try {
            List<Advisor> advisorList = new ArrayList<>();
            advisors.find(Advisor.class).into(advisorList);
            return advisorList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Advisor getAdvisorByAttribute(String field, String value) {
        if (field.equals("id")) {
            try {
                return advisors.find(Filters.eq(field, Integer.parseInt(value)), Advisor.class).first();
            } catch (Exception e) {
                return new Advisor();
            }
        } else {
            try {
                return advisors.find(Filters.eq(field, value), Advisor.class).first();
            } catch (Exception e) {
                return new Advisor();
            }
        }
    }

    public int createAdvisor(Advisor advisor) {
        try {
            advisors.insertOne(advisor);
            return 200;
        } catch(Exception e) {
            return 500;
        }
    }
}
