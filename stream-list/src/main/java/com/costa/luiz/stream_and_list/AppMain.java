package com.costa.luiz.stream_and_list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
@EnableJpaRepositories
public class AppMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(ClientRepository repository) {
        List<Client> clients = new ArrayList<>();
        return args -> {
            IntStream.rangeClosed(0, 300_000)
                    .forEach(value -> clients.add(Client.ClientBuilder.aClient().withName("Person "+value).build()));
            repository.saveAll(clients);
            LOGGER.info("All clients saved");
        };
    }
}
