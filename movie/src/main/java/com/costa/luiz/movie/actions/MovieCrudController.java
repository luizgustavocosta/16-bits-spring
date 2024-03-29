package com.costa.luiz.movie.actions;

import com.costa.luiz.movie.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/crud/movies")
public class MovieCrudController {

    @Autowired
    private final MovieService service;

    private final MovieMapper mapper;

    public MovieCrudController(MovieService service, MovieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<MovieRequest> allMovies() {
        return StreamSupport.stream(service.findAllByCrud().spliterator(), false)
                .map(mapper::map)
                .collect(Collectors.toUnmodifiableList());
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieRequest movieBy(@PathVariable String id) {
        return mapper.map(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAMovie(@RequestBody MovieRequest request) {
        service.saveUsingCrud(request.getName(), request.getYear());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAMovie(@RequestBody MovieRequest request) {
        service.saveUsingCrud(request.getId(), request.getName(), request.getYear());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAMovieBy(@PathVariable String id) {
        service.deleteBy(id);
    }
}
