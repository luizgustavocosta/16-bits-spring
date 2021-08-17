package com.costa.luiz.repository.actions;

import com.costa.luiz.repository.model.Movie;
import com.costa.luiz.repository.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/crud/movies")
public class SearchMoviesUsingCrud {

    @Autowired
    private final MovieService service;

    public SearchMoviesUsingCrud(MovieService service) {
        this.service = service;
    }

    @GetMapping
    Iterable<Movie> allMovies() {
        return service.findAllByCrud();
    }
}
