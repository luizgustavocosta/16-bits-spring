package com.costa.luiz.airbnb.controller;

import com.costa.luiz.airbnb.repository.ReviewRepository;
import com.costa.luiz.airbnb.model.Reviews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/async/reviews")
public class ReviewAsyncController {

    private final Logger logger = LoggerFactory.getLogger(ReviewAsyncController.class);

    private final ReviewRepository reviewRepository;

    public ReviewAsyncController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @GetMapping
    @Async
    CompletableFuture<List<Reviews>> getAll() {
        return CompletableFuture.completedFuture(reviewRepository.findAll());
    }

    @GetMapping("/{id}")
    @Async
    CompletableFuture<Reviews> findOne(@PathVariable String id) {
        logger.info("Looking for {}", id);
        return CompletableFuture.completedFuture(reviewRepository.findFirstById(id));
    }
}
