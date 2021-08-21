package com.costa.luiz.twitter;

import com.costa.luiz.twitter.ui.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
public class AppMain {

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
        showMenu();
    }

    private static void showMenu() {
        System.out.println("**** Menu ****");
        System.out.println("Options accepted");
        System.out.println("exit - Close the menu");
        System.out.println("0 - Count all posts");
        System.out.println("1 - Create a random post");
        System.out.println("2 - Read all posts");
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
        System.out.println("How many posts stored ?"+ Menu.countPosts());
    }

    private static void readAllPosts() {
        System.out.println("Looking for all post");
        System.out.println(("....."));
        System.out.println(Menu.findAllCrud().stream()
                .map(post ->
                        String.join(",",
                                post.getUser(), post.getContent(), "\n"))
                .collect(Collectors.toUnmodifiableList()));
        System.out.println(("....."));
    }

    private static void createRandomPost() {
        Menu.createARandomPost();
    }
}
