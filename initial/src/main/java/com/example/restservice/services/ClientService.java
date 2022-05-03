package com.example.restservice.services;

import com.example.restservice.mocks.ClientRepository;
import com.example.restservice.mocks.ProjectRepository;
import com.example.restservice.models.*;

import java.util.List;

public class ClientService {

    ClientRepository repository;
    ProjectRepository projectRepository;
    ScoreRequestService scoreRequestService;

    public ClientService(ClientRepository repository1, ProjectRepository projectRepository1, ScoreRequestService scoreRequestService1) {
        repository = repository1;
        projectRepository = projectRepository1;
        scoreRequestService = scoreRequestService1;
    }

    public List<Client> getClients() {
        return repository.getClients();
    }

    public Client getClient(String id) {
        return repository.getClientByID(id);
    }

    public Client getClientFromUsername(String username) { return repository.getClientByUsername(username); }

    public int addClient(Client newClient) {
        List<Client> currentClients = getClients();
        int maxId = 0;
        for (Client client : currentClients) {
            if (client.getId() > maxId) {
                maxId = client.getId();
            }
        }
        newClient.setId(maxId+1);
        newClient.setRecommendation(fetchRecommendation(newClient.getScores()));
        return repository.createClient(newClient);
    }

    private String fetchRecommendation(Scores scores) {
        Project recommendedProject;
        String recommendation = scoreRequestService.calculateRecommendation(scores);
        String recommendationId = recommendation.substring(7, recommendation.length()-2);
        if (recommendationId.equals("-1")) {
            return "";
        }
        recommendedProject = projectRepository.getProjectByID(recommendationId);
        return recommendedProject.getName();
    }

    public int updateClient(String clientId, Client newClient) {
        newClient.setRecommendation(fetchRecommendation(newClient.getScores()));
        return repository.updateClient(clientId, newClient);
    }
}
