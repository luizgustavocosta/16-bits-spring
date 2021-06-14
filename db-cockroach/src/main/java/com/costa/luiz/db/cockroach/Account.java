package com.costa.luiz.db.cockroach;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final String iban;
    private final boolean active;
    private final BigDecimal balance;
}
