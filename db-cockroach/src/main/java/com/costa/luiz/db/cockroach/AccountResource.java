package com.costa.luiz.db.cockroach;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {

    @GetMapping("{id}")
    public Account findById() {
        return null;
    }

}
