package com.costa.luiz.airbnb.controller;

import com.costa.luiz.airbnb.repository.ReviewRepository;
import com.costa.luiz.airbnb.model.Reviews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/block/reviews")
public class ReviewBlockController {

    private final Logger logger = LoggerFactory.getLogger(ReviewBlockController.class);

    private final ReviewRepository blockRepository;

    public ReviewBlockController(ReviewRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @GetMapping
    List<Reviews> findAll() {
        logger.info("Give me all reviews");
        return blockRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reviews findOne(@PathVariable String id) {
        logger.info("Give me one using the id {}", id);
        blockRepository.save(new Reviews("A", "16bits", "TEst", "Other test"));
        return blockRepository.findFirstById(id);
    }
}
