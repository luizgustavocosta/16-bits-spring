package com.costa.luiz.lombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
class CountryService {

    @Autowired
    private final CountryRepository repository;

    CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    List<Country> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
