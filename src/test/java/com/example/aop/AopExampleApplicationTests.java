package com.example.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AopExampleApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        assertNotNull(userService);
    }

    @Test
    void testCreateUser() {
        assertDoesNotThrow(() -> userService.createUser("Test User", "test@example.com"));
    }

    @Test
    void testGetUserById() {
        String result = userService.getUserById(1L);
        assertEquals("User-1", result);
    }

    @Test
    void testDeleteUserWithValidId() {
        assertDoesNotThrow(() -> userService.deleteUser(50L));
    }

    @Test
    void testDeleteUserWithInvalidId() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.deleteUser(999L);
        });
        assertTrue(exception.getMessage().contains("User not found"));
    }

    @Test
    void testUpdateUser() {
        assertDoesNotThrow(() -> userService.updateUser(1L, "Updated Name"));
    }
}
