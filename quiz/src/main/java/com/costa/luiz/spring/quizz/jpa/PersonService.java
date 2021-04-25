package com.costa.luiz.spring.quizz.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository repository;

    PersonService(PersonRepository repository) {
        this.repository = repository;
    }

//    @Transactional
    public Person create(String name) {
        log.info("Has transaction active? {}", TransactionSynchronizationManager.isActualTransactionActive());
        final Person person = repository.save(new Person(name));
        person.setName("Replace the name at " + LocalDateTime.now());
        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(persons::add);
        return persons;
    }
}

