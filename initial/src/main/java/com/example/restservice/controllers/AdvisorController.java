package com.example.restservice.controllers;

import com.example.restservice.models.Advisor;
import com.example.restservice.services.AdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvisorController {

    AdvisorService service = new AdvisorService();

    public AdvisorController() {
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/advisors")
    public ResponseEntity<List<Advisor>> getAdvisorList() {
        List<Advisor> advisors = service.getAdvisors();
        if (advisors.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(advisors);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/advisor/{advisorId}")
    public ResponseEntity<Advisor> getAdvisor(@PathVariable String advisorId) {
        Advisor advisor = service.getAdvisorFromAttribute("id", advisorId);
        if (advisor.equals(new Advisor())) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(advisor);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/advisor/username/{advisorUsername}")
    public ResponseEntity<Advisor> getAdvisorFromUsername(@PathVariable String advisorUsername) {
        Advisor advisor = service.getAdvisorFromAttribute("user.username", advisorUsername);
        if (advisor.equals(new Advisor())) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(advisor);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/addAdvisor")
    public ResponseEntity<Advisor> addAdvisor(@RequestBody Advisor advisor) {
        int response = service.addAdvisor(advisor);
        return ResponseEntity.status(response).body(advisor);
    }
}
