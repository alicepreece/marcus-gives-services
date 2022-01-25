package com.example.restservice.services;

import com.example.restservice.models.Client;

public class ClientService {

    public ClientService(){
    }

    public static void main(String[] args) {
    }

    public static Client getClientWithId(String id) {
        if (id != null) {
            int convertedId = Integer.parseInt(id);
            return new Client(convertedId, "Hermione", "Granger");
        } else {
            return new Client(999, "Error", "Error");
        }
    }
}
