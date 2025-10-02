package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopExampleApplication.class, args);
        
        // Demonstrate AOP in action
        UserService userService = context.getBean(UserService.class);
        
        System.out.println("\n===== Calling createUser() =====");
        userService.createUser("John Doe", "john@example.com");
        
        System.out.println("\n===== Calling getUserById() =====");
        userService.getUserById(1L);
        
        System.out.println("\n===== Calling deleteUser() =====");
        try {
            userService.deleteUser(999L);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\n===== AOP Example Completed =====");
    }
}
