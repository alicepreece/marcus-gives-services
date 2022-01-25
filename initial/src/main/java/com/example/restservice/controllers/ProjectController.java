package com.example.restservice.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice.dataAccess.ProjectRepository;
import com.example.restservice.models.Client;
import com.example.restservice.models.Project;
import com.example.restservice.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

	ProjectRepository repository = new ProjectRepository();

	public ProjectController() {
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/projects")
	public ResponseEntity<List<Project>> getProjectList() {
		List<Project> projects = repository.getProjects();
		return ResponseEntity.status(200).body(projects);
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/project/{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable String projectId) {
		Project project = repository.getProjectByID(projectId);
		return ResponseEntity.status(200).body(project);
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addProjects")
	public ResponseEntity<Object>addProjects(String id) {

		return ResponseEntity.ok().body(id);
	}
}
