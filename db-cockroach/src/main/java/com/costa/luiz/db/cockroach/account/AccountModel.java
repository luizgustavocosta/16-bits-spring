package com.costa.luiz.db.cockroach.account;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value = "account", collectionRelation = "accounts")
public class AccountModel extends RepresentationModel<AccountModel> {

    private AccountType type;
    private BigDecimal balance;

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}