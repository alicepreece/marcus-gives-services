package com.example.restservice.controllers;

import com.example.restservice.models.Client;
import com.example.restservice.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    ClientService service = new ClientService();

    public ClientController(){
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClientList() {
        List<Client> clients = service.getClients();
        if (clients.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(clients);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/client/{clientId}")
    public ResponseEntity<Client> getClient(@PathVariable String clientId) {
        Client client = service.getClient(clientId);
        if (client.equals(new Client())) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(client);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/client/username/{clientUsername}")
    public ResponseEntity<Client> getClientFromUsername(@PathVariable String clientUsername) {
        Client client = service.getClientFromUsername(clientUsername);
        if (client.equals(new Client())) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(client);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/addClient")
    public ResponseEntity<Object>addClient(@RequestBody Client client) {
        int status = service.addClient(client);
        return ResponseEntity.status(status).body(null);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping("/updateClient/{clientId}")
    public ResponseEntity<Object>updateClient(@PathVariable String clientId, @RequestBody Client client) {
        int status = service.updateClient(clientId, client);
        return ResponseEntity.status(status).body(null);
    }
}
