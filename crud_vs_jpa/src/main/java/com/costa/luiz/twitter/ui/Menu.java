package com.costa.luiz.twitter.ui;

import com.costa.luiz.twitter.model.Post;
import com.costa.luiz.twitter.model.PostCrudRepository;
import com.costa.luiz.twitter.model.PostJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Slf4j
public class Menu {

    private static PostCrudRepository crudRepository;
    private static PostJpaRepository jpaRepository;

    private static final List<String> USERS = List.of("messi", "mbappe", "realAlfonso");

    @Autowired
    public Menu(PostCrudRepository crudRepository, PostJpaRepository jpaRepository) {
        Menu.crudRepository = crudRepository;
        Menu.jpaRepository = jpaRepository;
    }

    public static List<Post> findAllCrud() {
        return StreamSupport.stream(crudRepository.findAll().spliterator(), false)
                .collect(Collectors.toUnmodifiableList());
    }

    public static long countPosts() {
        return crudRepository.count();
    }

    public static void createARandomPost() {
        Post post = jpaRepository.save(Post.builder()
                .user(getRandomUser())
                .content("I'm a random content using an ID " + UUID.randomUUID().toString().substring(0, 10))
                .createdAt(ZonedDateTime.now())
                .build());
        log.info("New post created by {}", post.getUser());
    }

    /**
     * // For a multithread env int index = ThreadLocalRandom.current().nextInt(USERS.size()) % USERS.size();
     * @return user {@link String}
     */
    private static String getRandomUser() {
        return USERS.get(new Random().nextInt(USERS.size()));
    }
}
