package com.costa.luiz.db.cockroach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private final BankRepository repository;

    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    Iterable<Account> findAll() {
        return repository.findAll();
    }
}
