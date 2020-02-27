package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.RegisterAndUpdateDAO;
import com.Flashycards.Flashycards.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private MockMvc mvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void create_user_Test() throws Exception {

        String response = "Account Created";
        RegisterAndUpdateDAO user = new RegisterAndUpdateDAO(
                "arguello.chung@gmail.com",
                "chungarguello",
                "Chung11161989.",
                "Chung11161989."
        );

        given(userService.createUser(user)).willReturn(response);

        mvc.perform(
                post("/api/user/register")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());

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
