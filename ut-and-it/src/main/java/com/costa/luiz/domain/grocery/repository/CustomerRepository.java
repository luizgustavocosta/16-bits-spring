package com.costa.luiz.domain.grocery.repository;

import com.costa.luiz.domain.grocery.model.Customer;
import com.costa.luiz.domain.grocery.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
