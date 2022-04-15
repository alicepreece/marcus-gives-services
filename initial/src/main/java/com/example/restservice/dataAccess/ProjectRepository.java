package com.example.restservice.dataAccess;

import com.example.restservice.DBConnection;
import com.example.restservice.models.Project;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
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

    public int updateProject(String projectId, Project project) {
        try {
            projects.updateOne(Filters.eq("id", Integer.parseInt(projectId)),
                    Updates.combine(
                            Updates.set("name", project.getName()),
                            Updates.set("goal", project.getGoal()),
                            Updates.set("region", project.getRegion()),
                            Updates.set("aims", project.getAims()),
                            Updates.set("strategy", project.getStrategy()),
                            Updates.set("fees", project.getFees()),
                            Updates.set("scores.socialOverEnv", project.getScores().getSocialOverEnv()),
                            Updates.set("scores.economyOverHealthcare", project.getScores().getEconomyOverHealthcare()),
                            Updates.set("scores.povertyOverEducation", project.getScores().getPovertyOverEducation()),
                            Updates.set("scores.targetedOverDiverse", project.getScores().getTargetedOverDiverse()),
                            Updates.set("scores.managementFees", project.getScores().getManagementFees()),
                            Updates.set("scores.esgOverAll", project.getScores().getEsgOverAll()),
                            Updates.set("scores.shortOverLongTerm", project.getScores().getShortOverLongTerm())
                    )
            );
            return 200;
        } catch(Exception e) {
            throw e;
        }
    }

    public int updateProjectDonation(Project project, int value, int clientId) {
        try {
            int total = project.getTotal() + value;
            List<Integer> investors = project.getInvestors();
            if (investors == null) {
                investors = new ArrayList<>();
            }
            investors.add(clientId);
            projects.updateOne(Filters.eq("id", project.getId()),
                    Updates.combine(
                            Updates.set("total", total),
                            Updates.set("investors", investors)
                    )
            );
            return 200;
        } catch (Exception e) {
            throw e;
        }
    }

    public int cancelProjectDonation(Project project, int value, int clientId) {
        try {
            int total = project.getTotal() - value;
            List<Integer> investors = project.getInvestors();
            int index = investors.indexOf(clientId);
            if (index != -1) {
                investors.remove(index);
            } else {
                return 500;
            }
            projects.updateOne(Filters.eq("id", project.getId()),
                    Updates.combine(
                            Updates.set("total", total),
                            Updates.set("investors", investors)
                    )
            );
            return 200;
        } catch (Exception e) {
            throw e;
        }
    }
}