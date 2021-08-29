package com.personal_log;

import com.personal_log.utility.EnvironmentalConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles(value = EnvironmentalConstants.PROD)
public class ProdEnvVariables {

    @Autowired
    Environment env;

    private boolean inProdEnv() {
        return Arrays.stream(env.getActiveProfiles())
                .anyMatch(
                        profile -> profile.equals(EnvironmentalConstants.PROD));
    }

    @Test
    public void prodEnvTest() {
        assertTrue(inProdEnv());
    }

    @Test
    public void mongoDataIsPresent() {
        var adminUsername = env.getProperty("spring.data.mongodb.host");
        var adminPassword = env.getProperty("spring.data.mongodb.password");
        var url = env.getProperty("spring.data.mongodb.localhost");
        assertTrue(adminUsername.length() > 0
                && adminPassword.length() > 0
                && url.length() > 0);
    }

    @Test
    public void aProfileIsActive() {
        assertTrue(env.getActiveProfiles().length > 0);
    }
}
