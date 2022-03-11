package com.example.restservice.services;

import com.example.restservice.dataAccess.ProjectRepository;
import com.example.restservice.models.Project;
import com.example.restservice.models.Scores;

import java.util.List;

public class ProjectService {
    ProjectRepository repository;

    public ProjectService(){
        repository = new ProjectRepository();
    }

    public static void main(String[] args) {

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

    public int addProjectScore(Scores newProjectScore) { return repository.addProjectScore(newProjectScore); }
}