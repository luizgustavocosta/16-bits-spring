package com.costa.luiz.repository.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private final MoviesCrudRepository repository;

    public MovieService(MoviesCrudRepository repository) {
        this.repository = repository;
    }

    public Iterable<Movie> findAllByCrud() {
        return repository.findAll();
    }
}
