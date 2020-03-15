package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.RegisterAndUpdateDAO;
import com.Flashycards.Flashycards.models.User;
import com.Flashycards.Flashycards.models.enums.Roles;
import com.Flashycards.Flashycards.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
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



    // converts objects to json format
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
