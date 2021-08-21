package com.costa.luiz.airbnb.controller;

import com.costa.luiz.airbnb.repository.ReactiveReviewRepository;
import com.costa.luiz.airbnb.model.Reviews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReviewReactiveController {

    private final Logger logger = LoggerFactory.getLogger(ReviewReactiveController.class);

    @Autowired
    private final ReactiveReviewRepository repository;

    public ReviewReactiveController(ReactiveReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/api/v1/airbnb/reviews", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Reviews> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/api/v1/airbnb/reviews/{page}/{size}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Reviews> findAll(@PathVariable int page, @PathVariable int size) {
        return repository.findAllByIdNotNull(PageRequest.of(page, size)); // Programmatically
    }

    @GetMapping(value = "/api/v1/airbnb/reviews/{id}")
    Mono<Reviews> findOne(@PathVariable String id) {
        logger.info("Calling by id {}", id);
        return repository.findOneById(id);
    }
}
