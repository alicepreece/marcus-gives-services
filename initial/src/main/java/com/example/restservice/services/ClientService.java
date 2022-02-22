package com.example.restservice.services;

import com.example.restservice.dataAccess.ClientRepository;
import com.example.restservice.models.Client;

import java.util.List;

public class ClientService {

    ClientRepository repository;

    public ClientService(){
        repository = new ClientRepository();
    }

    public static void main(String[] args) {
    }

    public List<Client> getClients() {
        return repository.getClients();
    }

    public Client getClient(String id) {
        return repository.getClientByID(id);
    }

    public Client getClientFromUsername(String username) { return repository.getClientByUsername(username); }
}
