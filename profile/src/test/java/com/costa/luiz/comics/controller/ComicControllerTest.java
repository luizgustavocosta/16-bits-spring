package com.costa.luiz.comics.controller;

import com.costa.luiz.comics.domain.CharacterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Comic controller")
@WebMvcTest(ComicController.class)
class ComicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CharacterService service;

    @Test
    @WithMockUser(roles = "READER")
    void preview() throws Exception {
        mockMvc.perform(get("/preview"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void redirectToLoginPage() throws Exception {
        mockMvc.perform(get("/preview"))
            .andDo(print())
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(roles = "WRITER", username = "Rick")
    void characters() throws Exception {
        mockMvc.perform(get("/characters").contentType("application/json"))
            .andDo(print())
            .andExpect(status().isOk());
    }
}
