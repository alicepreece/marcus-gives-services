package com.example.restservice.services;

import com.example.restservice.repositories.ClientRepository;
import com.example.restservice.repositories.ProjectRepository;
import com.example.restservice.models.Donation;
import com.example.restservice.models.Project;
import com.example.restservice.models.requestModels.DonationRequest;

import java.util.List;

public class ProjectService {
    ProjectRepository repository;
    ClientRepository clientRepository;

    public ProjectService(ProjectRepository projectRepository, ClientRepository clientRepository1){
        repository = projectRepository;
        clientRepository = clientRepository1;
    }

    public List<Project> getProjects() {
        return repository.getProjects();
    }

    public Project getProjectByID(String projectId) {
        return repository.getProjectByID(projectId);
    }

    public int addProject(Project newProject) {
        return repository.createProject(newProject);
    }

    public int updateProject(String projectId, Project newProject) {
        return repository.updateProject(projectId, newProject);
    }

    public int donate(DonationRequest donationRequest) {
        Project project = repository.getProjectByID(donationRequest.getProjectId().toString());
        int amountValue = donationRequest.getAmount();
        int timeStamp = donationRequest.getTimestamp();
        Donation donation = new Donation(project, amountValue, timeStamp);
        int statusProject = repository.updateProjectDonation(
                project,
                amountValue,
                donationRequest.getClientId()
        );
        int statusClient = clientRepository.updateClientDonation(
                donationRequest.getClientId(),
                donation
        );
        if (statusClient == 200 && statusProject == 200) {
            return 200;
        } else {
            return 500;
        }
    }

    public int cancelDonation(DonationRequest donationRequest) {
        Project project = repository.getProjectByID(donationRequest.getProjectId().toString());
        int amountValue = donationRequest.getAmount();
        assert donationRequest.getClientId() != null;
        int clientId = donationRequest.getClientId();
        Donation donation = new Donation(project, amountValue, donationRequest.getTimestamp());
        int statusProject = repository.cancelProjectDonation(project, amountValue, clientId);
        int statusClient = clientRepository.cancelDonation(clientId, donation);
        if (statusClient == 200 && statusProject == 200) {
            return 200;
        } else {
            System.out.println(statusClient + statusProject);
            return 500;
        }
    }
}