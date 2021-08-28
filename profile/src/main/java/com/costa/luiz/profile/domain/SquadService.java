package com.costa.luiz.profile.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquadService {

    private final SquadRepository repository;

    public SquadService(SquadRepository repository) {
        this.repository = repository;
    }

    public List<Squad> findAll() {
        return repository.findAll();
    }
}
