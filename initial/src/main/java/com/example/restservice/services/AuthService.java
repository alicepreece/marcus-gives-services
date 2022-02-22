package com.example.restservice.services;

import com.example.restservice.dataAccess.UserRepository;
import com.example.restservice.models.User;
import com.example.restservice.models.requestModels.AuthRequest;
import com.example.restservice.models.responseModels.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    UserRepository repository;

    public AuthService(){
        repository = new UserRepository();
    }

    public AuthResponse authenticateUser(AuthRequest body) {
        try {
            User user = repository.findUserWithUsername(body.getUsername());
            if (user.equals(new User())) {
                return new AuthResponse(new User(), "No user with that username found", false);
            } else {
                if (user.getPassword().equals(body.getPassword())) {
                    return new AuthResponse(user, "Authenticated", true);
                } else {
                    return new AuthResponse(new User(), "Incorrect Password", false);
                }
            }
        } catch(Exception e) {
            throw e;
        }
    }
}
