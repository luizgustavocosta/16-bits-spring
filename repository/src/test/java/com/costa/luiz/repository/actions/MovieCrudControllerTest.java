package com.costa.luiz.repository.actions;

import com.costa.luiz.repository.model.Movie;
import com.costa.luiz.repository.model.MovieService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieCrudController.class)
class MovieCrudControllerTest implements WithAssertions {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService service;

    @Test
    @WithMockUser
    @DisplayName("Find all movie by Crud")
    void findAll() throws Exception {
        when(service.findAllByCrud()).thenReturn(List.of(new Movie("1", "Matrix", "1999")));
        var path = "/api/v1/crud/movies";
        mockMvc.perform(get(path))
                .andExpect(content().json("[{\"id\":\"1\",\"name\":\"Matrix\",\"year\":\"1999\"}]"))
                .andExpect(status().isOk());
    }

}
