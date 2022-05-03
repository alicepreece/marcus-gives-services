package com.example.restservice.mocks;

import com.example.restservice.DBConnection;
import com.example.restservice.models.Advisor;
import com.example.restservice.models.Client;
import com.example.restservice.models.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class UserRepository {
    private MongoCollection<Client> clients;
    private MongoCollection<Advisor> advisors;


    public UserRepository() {
        MongoDatabase database = DBConnection.getDBConnection().getDatabase("marcus-gives");
        clients = database.getCollection("clients", Client.class);
        advisors = database.getCollection("advisors", Advisor.class);
    }

    public User findUserWithUsername(String username) {
        Client client = clients.find(Filters.eq("user.username", username), Client.class).first();
        Advisor advisor = advisors.find(Filters.eq("user.username", username), Advisor.class).first();
        if (client == null && advisor == null) {
            return new User();
        } else {
            if (client != null) {
                return client.getUser();
            } else {
                return advisor.getUser();
            }
        }
    }
}
