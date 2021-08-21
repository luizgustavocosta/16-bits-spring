package com.costa.luiz.twitter.model;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DisplayName("Jpa Repository")
@DataJpaTest
@ExtendWith(SpringExtension.class)
class PostJpaRepositoryTest implements WithAssertions {

    @Autowired
    PostJpaRepository jpaRepository;

    @DisplayName("Delete all in batch")
    @Test
    @Sql("/data.sql")
    void deleteAllInBatch() {
        assertThat(jpaRepository.count()).isGreaterThan(0);
        // Attention for the documentation
        //Deletes the given entities in a batch which means it will create a single query.
        // This kind of operation leaves JPAs first level cache and the database out of sync.
        // Consider flushing the EntityManager before calling this method.
        jpaRepository.deleteAllInBatch();
        assertThat(jpaRepository.count()).isEqualTo(0);
    }

    @DisplayName("Find all using page")
    @Test
    @Sql("/data.sql")
    void findAllUsingPage() {
        var posts = jpaRepository.findAll(
                PageRequest.of(1, 2, Sort.by(Sort.Order.desc("createdAt"))))
                .getContent();

        assertThat(posts).extracting("user", "content")
                .contains(tuple("MrBeast", "Retweet, get paid"),
                        tuple("RyanSesseman", "1 dog = many retweets"));
    }

    @DisplayName("Find all using order by natural order")
    @Test
    @Sql("/data.sql")
    void findAllUsingOrderBy() {
        List<Post> posts = jpaRepository.findAll(Sort.by("createdAt", "user"));
        assertThat(posts).flatExtracting("createdAt", "user")
                .contains("TheEllenShow", "Rubiu5", "LuizCostaTech", "TheRock",
                        "LuizCostaTech", "RandallTime", "RyanSesseman", "MrBeast",
                        "btw_twt", "10Ronaldinho");
    }

}