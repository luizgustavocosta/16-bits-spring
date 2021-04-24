package com.costa.luiz.spring.quizz.jpa;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppMain {

    public static void main(String... args) {
        SpringApplication.run(AppMain.class, args);
    }

//    @Bean
//    ApplicationRunner applicationRunner(PersonService service) {
//        return args -> {
//            Person person = service.create("Larry");
//            person.setName("Lilly");
//            service.findAll().forEach(System.out::println);
//        };
//    }
}
