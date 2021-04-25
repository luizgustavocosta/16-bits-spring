package com.costa.luiz.spring.quizz.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerPersonRepository extends CrudRepository<InnerPerson, Integer> {
}
