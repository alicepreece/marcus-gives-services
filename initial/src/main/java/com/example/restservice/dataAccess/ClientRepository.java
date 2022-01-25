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
        List<Client> clientList = new ArrayList<>();
        clients.find(Client.class).into(clientList);
        return clientList;
    }

    public Client getClientByID(String filterID) {
        return clients.find(Filters.eq("id", Integer.parseInt(filterID)), Client.class).first();
    }


}
