package com.personal_log.database.repositories;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRepositoryTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUsers() throws Exception {
        MvcResult result = this.mvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn();
        String output = result.getResponse().getContentAsString();
        // will be used in next test
        // here as note
        JsonObject data = new JsonParser().parse(output).getAsJsonObject();

    }

}
