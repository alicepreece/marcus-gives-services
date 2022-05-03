package com.example.restservice.services;

import com.example.restservice.mocks.AdvisorRepository;
import com.example.restservice.models.Advisor;
import com.example.restservice.models.Client;
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

    public int addAdvisor(Advisor advisor) {
        List<Advisor> currectAdvisors = getAdvisors();
        int maxId = 0;
        for (Advisor advisor1 : currectAdvisors) {
            if (advisor.getId() > maxId) {
                maxId = advisor.getId();
            }
        }
        advisor.setId(maxId+1);
        return repository.createAdvisor(advisor);
    }
}
