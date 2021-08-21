package com.costa.luiz.twitter.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCrudRepository extends CrudRepository<Post, String> {

//    List<Post> findAllByName(String name);
//    List<Post> findAllByYearBetween(String start, String end);
//    List<Post> findAllByNameLike(String name);
//    List<Post> findAllByNameAndYear(String name, String year);
//
//    //NamedQuery
//    List<Post> findByNameAndYear(String name, String year);
//
//    //Native Query
//    @Query(value = "SELECT p.user FROM posts p WHERE p.content like %?1%", nativeQuery = true)
//    List<String> findMovieNameLike(String name);


}
