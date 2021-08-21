package com.costa.luiz.movie.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesCrudRepository extends CrudRepository<Movie, String> {

    List<Movie> findAllByName(String name);
    List<Movie> findAllByYearBetween(String start, String end);
    List<Movie> findAllByNameLike(String name);
    List<Movie> findAllByNameAndYear(String name, String year);

    //NamedQuery
    List<Movie> findByNameAndYear(String name, String year);

    //Native Query
    @Query(value = "SELECT name FROM Movies m WHERE m.name like %?1%", nativeQuery = true)
    List<String> findMovieNameLike(String name);


}
