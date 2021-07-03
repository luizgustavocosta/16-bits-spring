package com.costa.luiz.airbnb.repository;

import com.costa.luiz.airbnb.model.Reviews;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveReviewRepository extends ReactiveCrudRepository<Reviews, String> {

    Flux<Reviews> findAllByIdNotNull(final Pageable page);

    Mono<Reviews> findOneById(String id);
}
