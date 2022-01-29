package com.example.restservice.dataAccess;

import com.example.restservice.DBConnection;
import com.example.restservice.models.Project;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository {
    private MongoCollection<Project> projects;

    public ProjectRepository() {
        MongoDatabase database = DBConnection.getDBConnection().getDatabase("marcus-gives");
        projects = database.getCollection("projects", Project.class);
    }

    public List<Project> getProjects() {
        try {
            List<Project> projectList = new ArrayList<>();
            projects.find(Project.class).into(projectList);
            return projectList;
        } catch(Exception e) {
            return new ArrayList<>();
        }
    }

    public Project getProjectByID(String filterID) {
        try {
            return projects.find(Filters.eq("id", Integer.parseInt(filterID)), Project.class).first();
        } catch(Exception e) {
            return new Project();
        }
    }

    public int createProject(Project project) {
        try {
            projects.insertOne(project);
            return 200;
        } catch(Exception e) {
            return 500;
        }
    }
}