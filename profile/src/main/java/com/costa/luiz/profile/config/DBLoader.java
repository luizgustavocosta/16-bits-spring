package com.costa.luiz.profile.config;

import com.costa.luiz.profile.domain.Squad;
import com.costa.luiz.profile.domain.SquadRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBLoader {

    @Bean
    @Profile("dev")
    CommandLineRunner loadData(SquadRepository repository) {
        return args -> repository.saveAll(List.of(new Squad("Super man"), new Squad("Flash")));
    }

    @Bean
    @Profile("!dev")
    CommandLineRunner loadDefaultData(SquadRepository repository) {
        return args -> repository.saveAll(List.of(new Squad("Capitan America"), new Squad("Spider man")));
    }
}
