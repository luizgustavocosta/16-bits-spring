package com.costa.luiz.db.cockroach;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Account, Integer> {
}
