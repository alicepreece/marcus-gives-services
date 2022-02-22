package com.example.restservice.models.responseModels;

import com.example.restservice.models.User;

public class AuthResponse {
    private User user;
    private String message;
    private Boolean isAuthenticated;

    public AuthResponse(){}

    public AuthResponse(User user, String message, boolean isAuthenticated) {
        this.user = user;
        this.message = message;
        this.isAuthenticated = isAuthenticated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }
}
