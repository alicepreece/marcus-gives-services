package com.example.restservice.services;

import com.example.restservice.dataAccess.ClientRepository;
import com.example.restservice.dataAccess.ProjectRepository;
import com.example.restservice.models.*;

import java.util.List;

public class ClientService {

    ClientRepository repository;
    ProjectRepository projectRepository;
    ScoreRequestService scoreRequestService;

    public ClientService(){
        repository = new ClientRepository();
        projectRepository = new ProjectRepository();
        scoreRequestService = new ScoreRequestService();
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

    public String fetchRecommendation(Scores scores) {
        Project recommendedProject;
        String recommendation = scoreRequestService.calculateRecommendation(scores);
        String recommendationId = recommendation.substring(7, recommendation.length()-2);
        recommendedProject = projectRepository.getProjectByID(recommendationId);
        return recommendedProject.getName();
    }

    public int updateClient(String clientId, Client newClient) {
        newClient.setRecommendation(fetchRecommendation(newClient.getScores()));
        return repository.updateClient(clientId, newClient);
    }
}
