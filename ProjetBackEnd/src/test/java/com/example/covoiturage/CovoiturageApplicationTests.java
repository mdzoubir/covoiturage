package com.example.covoiturage;

import com.example.covoiturage.controllers.AuthController;
import com.example.covoiturage.request.SignupRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CovoiturageApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AuthController authController;

    @Test
    public void testHomeController() {
        SignupRequest request = new SignupRequest("zahddidfatima","nddnw","fwnnn@gmail.com", "zahid123", "0665754482");
        ResponseEntity<String> result = authController.registerUser(request);
        assertEquals(result, "User registered successfully!");
    }
}
