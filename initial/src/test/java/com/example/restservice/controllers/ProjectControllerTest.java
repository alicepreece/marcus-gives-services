package com.example.restservice.controllers;

import com.example.restservice.mocks.Mocks;
import com.example.restservice.models.Project;
import com.example.restservice.models.requestModels.DonationRequest;
import com.example.restservice.services.ProjectService;
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
public class ProjectControllerTest {

    @InjectMocks
    private ProjectController projectController = new ProjectController();

    @Mock
    private ProjectService projectService;

    @Test
    public void getProjectList() {
        when(projectService.getProjects()).thenReturn(Mocks.mockProjectList());
        ResponseEntity<List<Project>> response = ResponseEntity.status(200).body(Mocks.mockProjectList());
        assert(projectController.getProjectList().equals(response));
    }

    @Test
    public void getProject() {
        when(projectService.getProjectByID("1")).thenReturn(Mocks.mockProject());
        ResponseEntity<Project> response = ResponseEntity.status(200).body(Mocks.mockProject());
        assert(projectController.getProject("1").equals(response));
    }

    @Test
    public void addProject() {
        when(projectService.addProject(Mocks.mockProject())).thenReturn(200);
        ResponseEntity<Project> response = ResponseEntity.status(200).body(Mocks.mockProject());
        assert(projectController.addProject(Mocks.mockProject()).equals(response));
    }

    @Test
    public void updateProject() {
        when(projectService.updateProject("1", Mocks.mockProject())).thenReturn(200);
        ResponseEntity<Project> response = ResponseEntity.status(200).body(Mocks.mockProject());
        assert(projectController.updateProject("1", Mocks.mockProject()).equals(response));
    }

    @Test
    public void donate() {
        DonationRequest req = new DonationRequest(1, 1, 350, 543765);
        when(projectService.donate(req)).thenReturn(200);
        ResponseEntity<DonationRequest> response = ResponseEntity.status(200).body(req);
        assert(projectController.donate(req).equals(response));
    }

    @Test
    public void cancelDonation() {
        DonationRequest req = new DonationRequest(1, 1, 350, 543765);
        when(projectService.cancelDonation(req)).thenReturn(200);
        ResponseEntity<DonationRequest> response = ResponseEntity.status(200).body(req);
        assert(projectController.cancelDonation(req).equals(response));
    }
}
