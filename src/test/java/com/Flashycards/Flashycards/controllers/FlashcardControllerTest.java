package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.FlashcardDAO;
import com.Flashycards.Flashycards.service.FlashcardService;
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
@WebMvcTest(FlashcardController.class)
public class FlashcardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlashcardService flashcardService;

    @Test
    public void create_flashcard_test() throws Exception {
        FlashcardDAO flashcard = new FlashcardDAO("Testing Flashcard", "Testing 1 2 3");


        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/flashcards/create/{category}", 1)
                .content(UserControllerTest.asJsonString(flashcard))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();
    }
}
