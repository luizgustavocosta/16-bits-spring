package com.costa.luiz.spring.quizz.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
public class AppMainFromMaciej {

    private static final Logger log = LoggerFactory.getLogger(AppMainFromMaciej.class);

    public static void main(String... args) {
        SpringApplication.run(AppMainFromMaciej.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(InnerPersonService service) {
        return args -> {
            InnerPerson person = service.create("Larry");
            person.setName("Lilly");
            if (log.isInfoEnabled()) {
                log.info("Inner person -> {}", service.findOne(person.getId()));
            }
        };
    }

    @Service
    static class InnerPersonService {
        private final InnerPersonRepository repository;

        InnerPersonService(InnerPersonRepository repository) {
            this.repository = repository;
        }

        @Transactional
        public InnerPerson create(String name) {
            log.info("Has transaction active? {}", TransactionSynchronizationManager.isActualTransactionActive());
            final InnerPerson person = repository.save(new InnerPerson(name));
            person.setName("Lana");
            return person;
        }

        public InnerPerson findOne(Integer id) {
            return repository.findById(id).orElse(null);
        }
    }
}