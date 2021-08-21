package com.costa.luiz.movie.actions;

import com.costa.luiz.movie.model.Movie;
import com.costa.luiz.movie.model.MovieService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieJpaController.class)
@WithMockUser
@DisplayName("Movie Jpa Controller")
class MovieJpaControllerTest implements WithAssertions {

    private static final String URL_TEMPLATE = "/api/v1/jpa/movies";
    private static final String DEFAULT_MOVIE_AS_JSON = "{\"id\":\"1\",\"name\":\"Matrix\",\"year\":\"1999\"}";
    private static final Movie DEFAULT_MOVIE = Movie.builder().id("1").name("Matrix").year("1999").build();
    @Autowired
    MockMvc mockMvc;
    @MockBean
    MovieService service;
    @MockBean
    MovieMapper mapper;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach()
    void setup() {
        //Init MockMvc Object and build
        //https://stackoverflow.com/questions/53387415/unit-test-springboot-mockmvc-returns-403-forbidden
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Retrieve")
    void allMovies() throws Exception {
        when(service.findAllByJpa(0, 5, "name"))
                .thenReturn(List.of(DEFAULT_MOVIE));
        mockMvc.perform(get(URL_TEMPLATE))
                .andExpect(content().json("[" + DEFAULT_MOVIE_AS_JSON + "]"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Create")
    void createANewMovie() throws Exception {
        when(service.saveUsingJpa(any(String.class), any(String.class))).thenReturn(DEFAULT_MOVIE);
        mockMvc.perform(post(URL_TEMPLATE)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Matrix\",\"year\":\"1999\"}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Update")
    void updateAMovie() throws Exception {
        doNothing().when(service).saveUsingJpa(any(String.class), any(String.class), any(String.class));
        mockMvc.perform(put(URL_TEMPLATE)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(DEFAULT_MOVIE_AS_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete")
    void deleteMovie() throws Exception {
        var movieId = "42";
        doNothing().when(service).deleteBy(movieId);
        mockMvc.perform(delete(URL_TEMPLATE + "/{movieId}", movieId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}