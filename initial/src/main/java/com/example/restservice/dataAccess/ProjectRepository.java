package com.example.restservice.dataAccess;

import com.example.restservice.DBConnection;
import com.example.restservice.models.Project;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class ProjectRepository {
    private MongoCollection<Project> projects;

    public ProjectRepository() {
        MongoDatabase database = DBConnection.getDBConnection().getDatabase("marcus-gives");
        projects = database.getCollection("projects", Project.class);
    }

    public List<Project> getProjects() {
        List<Project> projectList = new ArrayList<>();
        projects.find(Project.class).into(projectList);
        return projectList;
    }

    public Project getProjectByID(String filterID) {
        return projects.find(Filters.eq("id", Integer.parseInt(filterID)), Project.class).first();
    }

    public void createProject() {
        List<Project> people = asList(
                new Project("id1", 345, "project 3", "region", "aims", "strategy", new ArrayList<>(), 789076),
                new Project("id2", 456, "project 4", "region", "aims", "strategy", new ArrayList<>(),9000000),
                new Project("id3", 567, "project 5", "region", "aims", "strategy", new ArrayList<>(),1234987)
        );
        projects.insertMany(people);
    }
}
