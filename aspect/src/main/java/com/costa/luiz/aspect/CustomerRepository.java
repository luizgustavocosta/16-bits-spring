package com.costa.luiz.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public class CustomerRepository {

    private final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    private final String twoArgs = "{} {}";

    String findBy(String id) {
        logger.info(twoArgs, "Find customer by id", id);
        return "Customer found";
    }

    boolean delete(Integer id) {
        logger.info(twoArgs, "Delete customer by id", id);
        return true;
    }

    boolean create(String name) {
        logger.info(twoArgs, "A new customer will be created using the name", name);
        return true;
    }

    Stream<String> findAll() {
        logger.info("{}", "Find all :>)");
        return Stream.of("A", "stream", "of", "objects");
    }
}
