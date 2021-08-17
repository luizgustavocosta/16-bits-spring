package com.costa.luiz.repository.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesCrudRepository extends CrudRepository<Movie, String> {
}
