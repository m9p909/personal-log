package com.personal_log.database.repositories;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.personal_log.database.entities.User;
import com.personal_log.utility.EnvironmentalConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({EnvironmentalConstants.TEST, EnvironmentalConstants.DEV})
public class UserRepositoryTest {
    final Gson gson = new Gson();
    final User test_user = new User("George M");

    @Autowired
    private MockMvc mvc;

    private JsonObject getResponseBodyAsJson(MvcResult res) throws UnsupportedEncodingException {
        String content = res.getResponse().getContentAsString();
        assert content.length() > 0 : "res has no response body";
        return (new JsonParser())
                .parse(res
                        .getResponse()
                        .getContentAsString())
                .getAsJsonObject();
    }

    @Test
    public void getUsersReturnsOK() throws Exception {
        MvcResult result = this.mvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void postUsersReturnsOk() throws Exception {
        final var postData = gson.toJson(test_user);
        MvcResult result = this.mvc
                .perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postData))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

}
