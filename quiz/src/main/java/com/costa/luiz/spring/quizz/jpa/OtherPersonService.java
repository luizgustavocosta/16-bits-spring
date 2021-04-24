package com.costa.luiz.spring.quizz.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.NEVER)
public class OtherPersonService {

    final PersonRepository repository;

    public OtherPersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, isolation = Isolation.READ_COMMITTED)
    public Person create(String name) {
        Person newPerson = new Person(name);
        final Person person = repository.save(newPerson);
        person.setName("New kid on the block");
        return person;
    }
}