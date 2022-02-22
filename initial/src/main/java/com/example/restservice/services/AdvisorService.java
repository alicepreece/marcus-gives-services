package com.example.restservice.services;

import com.example.restservice.dataAccess.AdvisorRepository;
import com.example.restservice.models.Advisor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisorService {

    AdvisorRepository repository;

    public AdvisorService(){
        repository = new AdvisorRepository();
    }

    public static void main(String[] args) {
    }

    public List<Advisor> getAdvisors() {
        return repository.getAdvisors();
    }

    public Advisor getAdvisorFromAttribute(String field, String value) {
        return repository.getAdvisorByAttribute(field, value);
    }
}
