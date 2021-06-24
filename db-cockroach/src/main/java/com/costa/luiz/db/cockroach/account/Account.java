package com.costa.luiz.db.cockroach.account;

import com.costa.luiz.db.cockroach.customer.Customer;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "customerid")
    private Customer customer;

    @Column(length = 25, nullable = false)
    private BigDecimal balance;

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

    public AccountType getType() {
        return type;
    }
}

