package com.example.restservice.services;

import com.example.restservice.mocks.ClientRepository;
import com.example.restservice.mocks.Mocks;
import com.example.restservice.mocks.ProjectRepository;
import com.example.restservice.models.Donation;
import com.example.restservice.models.requestModels.DonationRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProjectServiceTest {

    ClientRepository clientRepositoryMock;
    ProjectRepository projectRepositoryMock;
    ProjectService projectService;

    @Before
    public void setup() {
        projectRepositoryMock = mock(ProjectRepository.class);
        clientRepositoryMock = mock(ClientRepository.class);
        projectService = new ProjectService(projectRepositoryMock, clientRepositoryMock);
    }

    @Test
    public void getProjects() {
        Mockito.doReturn(Mocks.mockProjectList()).when(projectRepositoryMock).getProjects();
        assert(projectService.getProjects().toString().equals(Mocks.mockProjectList().toString()));
    }

    @Test
    public void getProjectById() {
        Mockito.doReturn(Mocks.mockProject()).when(projectRepositoryMock).getProjectByID("1");
        assert(projectService.getProjectByID("1").toString().equals(Mocks.mockProject().toString()));
    }

    @Test
    public void donate() {
        Mockito.doReturn(Mocks.mockProject()).when(projectRepositoryMock).getProjectByID("1");
        Mockito.doReturn(200).when(projectRepositoryMock)
                .updateProjectDonation(Mocks.mockProject(), 350, 1);
        DonationRequest req = new DonationRequest(1, 1, 350, 5703450);
        projectService.donate(req);
        verify(projectRepositoryMock).updateProjectDonation(Mocks.mockProject(), 350, 1);
    }

    @Test
    public void cancelDonation() {
        Mockito.doReturn(Mocks.mockProject()).when(projectRepositoryMock).getProjectByID("1");
        Mockito.doReturn(200).when(projectRepositoryMock).cancelProjectDonation(Mocks.mockProject(), 350, 1);
        DonationRequest req = new DonationRequest(1, 1, 350, 5703450);
        projectService.cancelDonation(req);
        verify(projectRepositoryMock).cancelProjectDonation(Mocks.mockProject(), 350, 1);
    }
}
