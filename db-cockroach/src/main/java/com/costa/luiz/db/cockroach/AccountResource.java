package com.costa.luiz.db.cockroach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {

    @Autowired
    private final BankService service;

    public AccountResource(BankService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Account findById() {
        return null;
    }

    @GetMapping("findall")
    public Iterable<Account> findAll() {
        return service.findAll();
    }
}
