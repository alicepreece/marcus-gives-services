package com.example.restservice.controllers;

import com.example.restservice.repositories.Mocks;
import com.example.restservice.models.Client;
import com.example.restservice.services.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ClientControllerTest {

    @InjectMocks
    private ClientController clientController = new ClientController();

    @Mock
    private ClientService clientService;

    @Test
    public void getClientList() {
        when(clientService.getClients()).thenReturn(Mocks.mockClientList());
        ResponseEntity<List<Client>> response = ResponseEntity.status(200).body(Mocks.mockClientList());
        assert(clientController.getClientList().equals(response));
    }

    @Test
    public void getClient() {
        when(clientService.getClient("1")).thenReturn(Mocks.mockClient1());
        ResponseEntity<Client> response = ResponseEntity.status(200).body(Mocks.mockClient1());
        assert(clientController.getClient("1").equals(response));
    }

    @Test
    public void getClientFromUsername() {
        when(clientService.getClientFromUsername("username")).thenReturn(Mocks.mockClient1());
        ResponseEntity<Client> response = ResponseEntity.status(200).body(Mocks.mockClient1());
        assert(clientController.getClientFromUsername("username").equals(response));
    }

    @Test
    public void addClient() {
        when(clientService.addClient(Mocks.mockClient1())).thenReturn(200);
        ResponseEntity<Object> response = ResponseEntity.status(200).body(null);
        assert(clientController.addClient(Mocks.mockClient1()).equals(response));
    }

    @Test
    public void updateClient() {
        when(clientService.updateClient("1", Mocks.mockClient1())).thenReturn(200);
        ResponseEntity<Object> response = ResponseEntity.status(200).body(null);
        assert(clientController.updateClient("1", Mocks.mockClient1()).equals(response));
    }
}
