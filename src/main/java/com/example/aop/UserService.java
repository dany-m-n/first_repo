package com.example.aop;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void createUser(String name, String email) {
        System.out.println("Creating user: " + name + " with email: " + email);
        // Simulate user creation logic
    }

    public String getUserById(Long id) {
        System.out.println("Fetching user with ID: " + id);
        // Simulate user retrieval logic
        return "User-" + id;
    }

    public void deleteUser(Long id) {
        System.out.println("Attempting to delete user with ID: " + id);
        if (id > 100) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        System.out.println("User deleted successfully");
    }

    public void updateUser(Long id, String name) {
        System.out.println("Updating user with ID: " + id + " to name: " + name);
        // Simulate user update logic
    }
}
