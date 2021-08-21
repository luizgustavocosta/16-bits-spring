package com.costa.luiz.movie.model;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest implements WithAssertions {

    @Mock
    private MoviesCrudRepository crudRepository;

    @Mock
    private MoviesJpaRepository jpaRepository;

    private static final String ID = "0";
    private static final String NAME = "Mr. Bean";
    private static final String YEAR = "2002";

    private MovieService service;

    @BeforeEach
    public void setUp() {
        service = new MovieService(crudRepository, jpaRepository);
    }

    @Test
    void findAllByCrud() {
        when(service.findAllByCrud()).thenReturn(List.of(Movie.builder().build()));
        Iterable<Movie> movies = service.findAllByCrud();
        verify(crudRepository, times(1)).findAll();
        assertThat(movies).isNotEmpty();
    }

    @Test
    void findAllByJpa() {
        var page = 0;
        var size = 5;
        var property = "name";
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(property));
        when(jpaRepository.findAll(pageRequest))
                .thenReturn(new PageImpl<Movie>(List.of(Movie.builder().build())));
        List<Movie> movies = service.findAllByJpa(page, size, property);
        verify(jpaRepository, times(1)).findAll(pageRequest);
        assertThat(movies).isNotEmpty();
    }

    @Test
    void saveUsingJpa() {
        var movie = Movie.builder().id(ID).name(NAME).year(YEAR).build();
        when(jpaRepository.saveAndFlush(any(Movie.class))).thenReturn(movie);
        Movie newMovie = service.saveUsingJpa(NAME, YEAR);
        assertThat(newMovie).hasNoNullFieldsOrProperties();
    }

    @Test
    void saveUsingCrud() {
        var movie = Movie.builder().id(ID).name(NAME).year(YEAR).build();
        when(crudRepository.save(any(Movie.class))).thenReturn(movie);
        service.saveUsingCrud(NAME, YEAR);
        verify(crudRepository, atLeastOnce()).save(any(Movie.class));
    }

    @Test
    void updateUsingCrud() {
        var movie = Movie.builder().id(ID).name(NAME).year(YEAR).build();
        when(crudRepository.save(any(Movie.class))).thenReturn(movie);
        when(crudRepository.findById(ID)).thenReturn(Optional.of(movie));
        service.saveUsingCrud(ID, NAME, YEAR);
        verify(crudRepository, atLeastOnce()).save(any(Movie.class));
    }

    @Test
    void deleteBy() {
        var movie = Movie.builder().id(ID).build();
        when(jpaRepository.findById(ID)).thenReturn(Optional.of(movie));
        doNothing().when(jpaRepository).delete(movie);
        service.deleteBy(ID);
        verify(jpaRepository, times(1)).findById(ID);
        verify(jpaRepository, times(1)).delete(movie);
    }

    @Test
    void findById() {
        when(crudRepository.findById(ID)).thenReturn(Optional.of(Movie.builder().id(ID).name(NAME).build()));
        var movie  = service.findById(ID);
        verify(crudRepository, times(1)).findById(ID);
        assertThat(movie).isNotNull().hasAllNullFieldsOrPropertiesExcept("id", "name");
    }
}