package com.personal_log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DevEnvVariables {

    @Value("${spring.data.mongodb.username}")
    private String adminusername;

    @Value("${spring.data.mongodb.password")
    private String adminPassword;

    @Value("${spring.data.mongodb.host")
    private String url;

    @Test
    public void mongoDataIsPresent() {
        assertTrue(adminusername.length() > 0
                && adminPassword.length() > 0
                && url.length() > 0);
    }
}
