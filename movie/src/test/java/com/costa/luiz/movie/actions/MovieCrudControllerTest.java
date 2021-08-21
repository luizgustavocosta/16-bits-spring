package com.costa.luiz.movie.actions;

import com.costa.luiz.movie.model.Movie;
import com.costa.luiz.movie.model.MovieService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieCrudController.class)
@AutoConfigureMockMvc(addFilters = false)
class MovieCrudControllerTest implements WithAssertions {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService service;

    @MockBean
    MovieMapper mapper;

    private final String URL_TEMPLATE = "/api/v1/crud/movies";

    @Test
    @DisplayName("Read all")
    void findAll() throws Exception {
        when(service.findAllByCrud()).thenReturn(List.of(new Movie("1", "Matrix", "1999")));
        when(mapper.map(any(Movie.class))).thenReturn(new MovieRequest("1", "Matrix", "1999"));
        mockMvc.perform(get(URL_TEMPLATE))
                .andExpect(content().json("[{\"id\":\"1\",\"name\":\"Matrix\",\"year\":\"1999\"}]"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Read by id")
    void findById() throws Exception {
        var id = "1";
        when(service.findById(id)).thenReturn(new Movie("1", "Matrix", "1999"));
        when(mapper.map(any(Movie.class))).thenReturn(new MovieRequest("1", "Matrix", ""));
        mockMvc.perform(get(URL_TEMPLATE+"/{id}", id))
                .andExpect(content().json("{\"id\":\"1\",\"name\":\"Matrix\",\"year\":\"\"}"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Create")
    void createANewMovie() throws Exception {
        doNothing().when(service).saveUsingCrud(any(String.class), any(String.class));
        mockMvc.perform(post(URL_TEMPLATE)
                .content("{\"name\":\"Matrix\",\"year\":\"1999\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Update")
    void updateAMovie() throws Exception {
        doNothing().when(service).saveUsingCrud(any(String.class), any(String.class), any(String.class));
        mockMvc.perform(put(URL_TEMPLATE)
                .content("{\"id\":\"1\",\"name\":\"Matrix\",\"year\":\"2000\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete")
    void deleteAMovie() throws Exception {
        var moviedId = "42";
        doNothing().when(service).deleteBy(moviedId);
        mockMvc.perform(delete(URL_TEMPLATE + "/{id}", moviedId))
                .andExpect(status().isOk());
    }
}

