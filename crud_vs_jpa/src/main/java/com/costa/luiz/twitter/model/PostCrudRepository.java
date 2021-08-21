package com.costa.luiz.twitter.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface PostCrudRepository extends CrudRepository<Post, String> {

    List<Post> findAllByUser(String user);
    List<Post> findAllByCreatedAtBetween(ZonedDateTime start, ZonedDateTime end);
    List<Post> findAllByUserContains(String user);

    //NamedQuery
    List<Post> findAllByUserAndPost(String user, String post);

    //Native Query
    @Query(value = "SELECT count(1) FROM posts p WHERE lower(p.content) like CONCAT('%',?1,'%')", nativeQuery = true)
    Long countPostContentWithContentLowerCase(String content);

}
