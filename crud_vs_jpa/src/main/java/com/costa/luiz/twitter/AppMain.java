package com.costa.luiz.twitter;

import com.costa.luiz.twitter.model.Post;
import com.costa.luiz.twitter.ui.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
@Slf4j
public class AppMain {

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
        showMenu();
    }

    private static void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if ("exit".equalsIgnoreCase(command)) {
                    //close all
                    break;
                }
                switch (command) {
                    case "0" : countPosts(); break;
                    case "1" : createRandomPost();break;
                    case "2" : readAllPosts();break;
                    default: break;
                }
            }
        }
    }

    private static void countPosts() {
        log.info("How many posts stored ? {}", Menu.countPosts());
    }

    private static void readAllPosts() {
        log.info("Read all posts");
        List<Post> allCrud = Menu.findAllCrud();
        System.out.println(allCrud);
    }

    private static void createRandomPost() {
        log.info("Creating new posts..coming soon");
    }
}
