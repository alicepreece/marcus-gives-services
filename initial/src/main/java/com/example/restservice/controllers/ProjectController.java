package com.example.restservice.controllers;

import java.util.List;

import com.example.restservice.repositories.ClientRepository;
import com.example.restservice.repositories.ProjectRepository;
import com.example.restservice.models.Project;
import com.example.restservice.models.Scores;
import com.example.restservice.models.requestModels.DonationRequest;
import com.example.restservice.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
	ProjectRepository repository = new ProjectRepository();
	ClientRepository clientRepository = new ClientRepository();
	ProjectService service = new ProjectService(repository, clientRepository);

	public ProjectController() {
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/projects")
	public ResponseEntity<List<Project>> getProjectList() {
		List<Project> projects = service.getProjects();
		if (projects.isEmpty()) {
			return ResponseEntity.status(404).body(null);
		} else {
			return ResponseEntity.status(200).body(projects);
		}
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/project/{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable String projectId) {
		Project project = service.getProjectByID(projectId);
		if (project.equals(new Project())) {
			return ResponseEntity.status(404).body(null);
		} else {
			return ResponseEntity.status(200).body(project);
		}
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addProject")
	public ResponseEntity<Object>addProject(@RequestBody Project project) {
		 int status = service.addProject(project);
		return ResponseEntity.status(status).body(project);
	}

	@CrossOrigin("http://localhost:4200")
	@PutMapping("/updateProject/{projectId}")
	public ResponseEntity<Object>updateProject(@PathVariable String projectId, @RequestBody Project project) {
		int status = service.updateProject(projectId, project);
		return ResponseEntity.status(status).body(project);
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping("/donate")
	public ResponseEntity<Object>donate(@RequestBody DonationRequest donationBody) {
		int status = service.donate(donationBody);
		System.out.println(status);
		return ResponseEntity.status(status).body(donationBody);
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping("/cancelDonation")
	public ResponseEntity<Object>cancelDonation(@RequestBody DonationRequest donationBody) {
		int status = service.cancelDonation(donationBody);
		return ResponseEntity.status(status).body(donationBody);
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/score/{projectId}")
	public ResponseEntity<Scores> getProjectScore(@PathVariable String projectId) {
		Project project = service.getProjectByID(projectId);
		if (project.equals(new Project())) {
			return ResponseEntity.status(404).body(null);
		} else {
			return ResponseEntity.status(200).body(project.getScores());
		}
	}
}
