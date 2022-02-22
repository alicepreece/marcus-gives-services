package com.example.restservice.controllers;

import com.example.restservice.models.requestModels.AuthRequest;
import com.example.restservice.models.responseModels.AuthResponse;
import com.example.restservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
public class AuthController {

    AuthService service = new AuthService();

    @CrossOrigin("http://localhost:4200")
    @RequestMapping("/token")
    public Map<String,String> token(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthRequest body) {
//        try {
            AuthResponse responseBody = service.authenticateUser(body);
            if (responseBody.getAuthenticated()) {
                return ResponseEntity.status(200).body(responseBody);
            }
            return ResponseEntity.status(401).body(responseBody);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(e);
//        }
    }
}