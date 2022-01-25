package com.example.restservice.controllers;

import com.example.restservice.dataAccess.ClientRepository;
import com.example.restservice.models.Client;
import com.example.restservice.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ClientController {

    ClientRepository repository = new ClientRepository();

    public ClientController(){}

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/clients")
    public ResponseEntity<ArrayList<Client>> getClientList() {
        ArrayList<Client> clients = new ArrayList<>();
        Client client1 = new Client(123, "Harry", "Potter");
        Client client2 = new Client(234, "Ronald", "Weasley");
        clients.add(client1);
        clients.add(client2);
        return ResponseEntity.status(200).body(clients);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/client/{clientId}")
    public ResponseEntity<Client> getClient(@PathVariable String clientId) {
        Client client1 = ClientService.getClientWithId(clientId);
        if (client1.getId() == 999) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(client1);
    }
}
