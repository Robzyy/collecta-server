package com.robzyy.Collecta_server.api;

import com.robzyy.Collecta_server.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class Users {
    private final List<User> users = new ArrayList<>(List.of(
            new User("Robzyy", "cclipicioiu@gmail.com", "Robzyy", "password", "2024-01-01T00:00:00"),
            new User("JohnDoe", "john@example.com", "JohnDoe", "password", "2024-01-01T00:00:00"),
            new User("JaneDoe", "jane@example.com", "JaneDoe", "password", "2024-01-01T00:00:00")
    ));

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        try {
            // Create a new user with the provided data
            User user = new User(
                newUser.getEmail(),
                newUser.getUsername(),
                newUser.getPassword()
            );
            
            // Check if username or email already exists
            boolean userExists = users.stream()
                    .anyMatch(existingUser -> 
                        existingUser.getUsername().equals(user.getUsername()) || 
                        existingUser.getEmail().equals(user.getEmail())
                    );
            
            if (userExists) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            // Add the new user to the list
            users.add(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            System.err.println("Registration error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
