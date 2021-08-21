package com.costa.luiz.movie.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration
@ComponentScan(basePackages = {"com.costa.luiz.movie.model"})
@EntityScan(basePackages = {"com.costa.luiz.repository.model"})
@EnableJpaRepositories(basePackages = {"com.costa.luiz.movie.model"})
public class MovieRepositoryTestConfiguration {

//    @MockBean
//    MovieMapper movieMapper;
}
