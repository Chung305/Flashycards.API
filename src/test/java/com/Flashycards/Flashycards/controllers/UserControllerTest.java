package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.RegisterAndUpdateDAO;
import com.Flashycards.Flashycards.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;


    @Test
    public void create_user_Test() throws Exception {
        RegisterAndUpdateDAO user =  new RegisterAndUpdateDAO(
                "arguello.chung@gmail.com",
                "chungarguello",
                "Chung11161989.",
                "Chung11161989."
        );
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/user/register")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void update_user_Test() throws Exception {
        RegisterAndUpdateDAO user =  new RegisterAndUpdateDAO(
                "arguello.chung@gmail.com",
                "chungarguello",
                "Chung11161989.",
                "Chung11161989."
        );
        RequestBuilder request = MockMvcRequestBuilders
                .put("/api/user/update/{id}", 2)
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void find_All_Test() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/user/all-users")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void delete_test() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .delete("/api/user/delete/{id}", 1);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isAccepted())
                .andReturn();
    }

    // converts objects to json format
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
