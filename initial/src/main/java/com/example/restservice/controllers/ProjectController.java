package com.example.restservice.controllers;

import java.util.List;

import com.example.restservice.models.Project;
import com.example.restservice.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
	ProjectService service = new ProjectService();

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
		return ResponseEntity.status(status).body(null);
	}
}
