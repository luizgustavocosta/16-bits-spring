package com.costa.luiz.db.cockroach;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false)
    private BigDecimal balance;

    @Column(length = 128, nullable = false, unique = true)
    private String name;

    @Column(length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType type;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public AccountType getType() {
        return type;
    }
}

