package com.costa.luiz.airbnb.repository;

import com.costa.luiz.airbnb.model.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews, String> {

    Reviews findFirstById(String id);
}
