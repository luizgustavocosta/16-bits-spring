package com.costa.luiz.profile.config;

import com.costa.luiz.profile.domain.FictionalCharacter;
import com.costa.luiz.profile.domain.FictionalCharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DBLoader {

    @Bean
    @Profile({"dev", "dc"})
    CommandLineRunner loadData(FictionalCharacterRepository repository) {
        return args -> repository.saveAll(
            Stream.of("Superman", "Batman", "Wonder Woman", "Green lantern", "Nightwing",
                "Flash", "Catwoman", "Shazan")
                .map(FictionalCharacter::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    @Bean
    @Profile({"marvel", "default"})
    CommandLineRunner loadDefaultData(FictionalCharacterRepository repository) {
        return args -> repository.saveAll(
            Stream.of("Capitan America", "Iron man", "Spider-man", "Black panther", "Deadpool",
                "Ant-man", "Luke Cage", "Capitan Marvel")
                .map(FictionalCharacter::new)
                .collect(Collectors.toUnmodifiableList()));
    }
}
