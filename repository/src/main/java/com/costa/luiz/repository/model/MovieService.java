package com.costa.luiz.repository.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private final MoviesCrudRepository crudRepository;

    @Autowired
    private final MoviesJpaRepository jpaRepository;

    public MovieService(MoviesCrudRepository crudRepository, MoviesJpaRepository jpaRepository) {
        this.crudRepository = crudRepository;
        this.jpaRepository = jpaRepository;
    }

    public Iterable<Movie> findAllByCrud() {
        return crudRepository.findAll();
    }

    public List<Movie> findAllByJpa(int page, int size, String property) {
        return jpaRepository.findAll(PageRequest.of(page, size, Sort.by(property))).getContent();
    }

    public void saveUsingJpa(String id, String name, String year) {
        jpaRepository.findById(id)
                .ifPresentOrElse(movie -> {
                    movie.setName(name);
                    movie.setYear(year);
                    jpaRepository.saveAndFlush(movie);
                }, () -> {
                    throw new IllegalArgumentException("Movie " + id + " not found");
                });
    }

    public Movie saveUsingJpa(String name, String year) {
        return jpaRepository.saveAndFlush(Movie.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .year(year)
                .build());
    }

    public void saveUsingCrud(String name, String year) {
        crudRepository.save(Movie.builder().id(UUID.randomUUID().toString()).name(name).year(year).build());
    }

    public void saveUsingCrud(String id, String name, String year) {
        crudRepository.findById(id)
                .ifPresentOrElse(movie -> {
                    movie.setName(name);
                    movie.setYear(year);
                    crudRepository.save(movie);
                }, () -> {
                    throw new IllegalArgumentException("Movie not found");
                });
    }

    public void deleteBy(String id) {
        jpaRepository.findById(id)
                .ifPresentOrElse(jpaRepository::delete,
                        () -> {
                            throw new IllegalArgumentException("Movie " + id + " not found");
                        });
    }

    public Movie findById(String id) {
        return crudRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
