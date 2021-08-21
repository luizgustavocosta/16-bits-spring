package com.costa.luiz.movie.model;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(inheritInitializers = PersistenceTestConfig.Initializer.class, classes = {PersistenceTestConfig.class})
@DataJpaTest
@Import(MovieRepositoryTestConfiguration.class)
class MoviesCrudRepositoryTest implements WithAssertions {

    @Autowired
    private MoviesCrudRepository repository;

    @Test
    @DisplayName("Retrieve all")
    @Sql("/data.sql")
    void findAll() {
        Iterable<Movie> movies = repository.findAll();
        assertThat(movies).isNotEmpty().hasSize(11);
    }

    @Test
    @DisplayName("Retrieve by id")
    @Sql("/data.sql")
    void findById() {
        var id = "6641272e-a26e-4e8c-881a-e6ad5ed0df2b";
        Optional<Movie> optionalMovie = this.repository.findById(id);
        assertTrue(optionalMovie.isPresent());
        Movie movie = optionalMovie.get();
        assertThat(movie.getName()).isEqualTo("A Bigger Splash");
    }

    @Test
    @DisplayName("Retrieve all by name")
    @Sql("/data.sql")
    void findAllByName() {
        var name = "A Better Life";
        List<Movie> movies = this.repository.findAllByName(name);
        assertThat(movies).isNotEmpty().doesNotContainNull().hasSize(2);
    }

    @Test
    @DisplayName("Retrieve all between year")
    @Sql("/data.sql")
    void findAllBetweenYears() {
        var start = "1999";
        var end = "2015";

        List<Movie> movies = this.repository.findAllByYearBetween(start, end);
        assertThat(movies).isNotEmpty().doesNotContainNull().hasSize(4);
    }

    @Test
    @DisplayName("Retrieve all by name and year by like name")
    @Sql("/data.sql")
    void findNameAndYearByNameLike() {
        var name = "Better";

        List<String> movies = this.repository.findMovieNameLike(name);
        assertThat(movies).isNotEmpty().doesNotContainNull().hasSize(5);
    }

}