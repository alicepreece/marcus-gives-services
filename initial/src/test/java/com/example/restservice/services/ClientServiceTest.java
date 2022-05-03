package com.example.restservice.services;

import com.example.restservice.repositories.ClientRepository;
import com.example.restservice.repositories.Mocks;
import com.example.restservice.repositories.ProjectRepository;
import com.example.restservice.models.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ClientServiceTest {

    ClientRepository clientRepositoryMock;
    ProjectRepository projectRepositoryMock;
    ClientService clientService;
    ScoreRequestService scoreRequestServiceMock;

    @Before
    public void setup() {
        clientRepositoryMock = mock(ClientRepository.class);
        projectRepositoryMock = mock(ProjectRepository.class);
        scoreRequestServiceMock = mock(ScoreRequestService.class);
        clientService = new ClientService(clientRepositoryMock, projectRepositoryMock, scoreRequestServiceMock);
    }

    @Test
    public void getClients() {
        Mockito.doReturn(Mocks.mockClientList()).when(clientRepositoryMock).getClients();
        List<Client> expected = Mocks.mockClientList();
        assert(clientService.getClients().toString().equals(expected.toString()));
    }

    @Test
    public void getClient() {
        Mockito.doReturn(Mocks.mockClient1()).when(clientRepositoryMock).getClientByID("1");
        Client expected = Mocks.mockClient1();
        assert(clientService.getClient("1").toString().equals(expected.toString()));
    }

    @Test
    public void getClientFromUsername() {
        Mockito.doReturn(Mocks.mockClient2()).when(clientRepositoryMock).getClientByUsername("username");
        Client expected = Mocks.mockClient2();
        assert(clientService.getClientFromUsername("username").toString().equals(expected.toString()));
    }

    @Test
    public void addClient() {
        Mockito.doReturn("'{'R': 1}'").when(scoreRequestServiceMock).calculateRecommendation(Mocks.mockScores());
        Mockito.doReturn(Mocks.mockProject()).when(projectRepositoryMock).getProjectByID("1");
        Mockito.doReturn(Mocks.mockClientList()).when(clientRepositoryMock).getClients();
        Client newClient = Mocks.mockClient1();
        newClient.setRecommendation("alpha");
        newClient.setId(3);
        clientService.addClient(Mocks.mockClient1());
        verify(projectRepositoryMock).getProjectByID("1");
    }

//    @Test
//    public void updateClient() {
//        Mockito.doReturn(200).when(clientRepositoryMock).updateClient("1", Mocks.mockClient1());
//        Mockito.doReturn("'{'R': 1}'").when(scoreRequestServiceMock).calculateRecommendation(Mocks.mockScores());
//        Mockito.doReturn(Mocks.mockProject()).when(projectRepositoryMock).getProjectByID("1");
//        assert(clientService.updateClient("1", Mocks.mockClient1()) == 200);
//    }
}
