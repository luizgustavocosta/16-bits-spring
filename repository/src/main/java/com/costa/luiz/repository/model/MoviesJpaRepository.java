package com.costa.luiz.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesJpaRepository extends JpaRepository<Movie, String> {
}
