package com.example.restservice.dataAccess;

import com.example.restservice.DBConnection;
import com.example.restservice.models.Client;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ClientRepository {
    private MongoCollection<Client> clients;


    public ClientRepository() {
        MongoDatabase database = DBConnection.getDBConnection().getDatabase("marcus-gives");
        clients = database.getCollection("clients", Client.class);
    }

    public List<Client> getClients() {
        try {
            List<Client> clientList = new ArrayList<>();
            clients.find(Client.class).into(clientList);
            return clientList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Client getClientByID(String filterID) {
        try {
            return clients.find(Filters.eq("id", Integer.parseInt(filterID)), Client.class).first();
        } catch (Exception e) {
            return new Client();
        }
    }

    public Client getClientByUsername(String filterUsername) {
        try {
            return clients.find(Filters.eq("user.username", filterUsername), Client.class).first();
        } catch (Exception e) {
            return new Client();
        }
    }

    public int createClient(Client client) {
        try {
            clients.insertOne(client);
            return 200;
        } catch(Exception e) {
            return 500;
        }
    }

}
