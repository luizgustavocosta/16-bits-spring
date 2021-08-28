package com.costa.luiz.comics.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final FictionalCharacterRepository repository;

    public CharacterService(FictionalCharacterRepository repository) {
        this.repository = repository;
    }

    public List<FictionalCharacter> findAll() {
        return repository.findAll();
    }
}
