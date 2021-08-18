package com.costa.luiz.repository.actions;

import com.costa.luiz.repository.model.Movie;
import com.costa.luiz.repository.model.MovieService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jpa/movies")
public class MovieJpaController {

    @Autowired
    private final MovieService service;

    public MovieJpaController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> allMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return service.findAllByJpa(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MovieRequest request) {
        service.saveUsingJpa(request.getName(), request.getYear());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody MovieRequest request) {
        service.saveUsingJpa(request.id, request.name, request.year);
    }

    @DeleteMapping(path = "/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String movieId) {
        service.deleteUsingJpa(movieId);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class MovieRequest {
        private String id;
        private String name;
        private String year;
    }
}
