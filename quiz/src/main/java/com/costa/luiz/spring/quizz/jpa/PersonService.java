package com.costa.luiz.spring.quizz.jpa;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class PersonService {
    private final PersonRepository repository;

    PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    //        @Transactional
    //javax.transaction.Transactional or  org.springframework.transaction.annotation.Transactional => Lana
    // Without Transactional annotation => Larry
    public Person create(String name) {
        Person newPerson = new Person(name);
        final Person person = repository.save(newPerson);
        createNewName(name, person);
        return person;
    }

    @Transactional
    public Person createUsingTransaction(String name) {
        Person newPerson = new Person(name);
        final Person person = repository.save(newPerson);
        createNewName(name, person);
        return person;
    }

    private void createNewName(String name, Person person) {
        person.setName("name replaced by " + UUID.randomUUID().toString().substring(0, 10));
    }

    public Person findOne(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(persons::add);
        return persons;
    }
}

