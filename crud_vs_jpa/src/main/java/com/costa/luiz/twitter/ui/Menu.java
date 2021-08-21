package com.costa.luiz.twitter.ui;

import com.costa.luiz.twitter.model.Post;
import com.costa.luiz.twitter.model.PostCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class Menu {

    private static PostCrudRepository crudRepository;

    @Autowired
    public Menu(PostCrudRepository crudRepository) {
        Menu.crudRepository = crudRepository;
    }

    public static List<Post> findAllCrud() {
        return StreamSupport.stream(crudRepository.findAll().spliterator(), false)
                .collect(Collectors.toUnmodifiableList());
    }

    public static long countPosts() {
        return crudRepository.count();
    }

}
