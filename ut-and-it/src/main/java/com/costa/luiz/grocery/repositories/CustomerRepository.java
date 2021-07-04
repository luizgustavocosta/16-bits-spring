package com.costa.luiz.grocery.repositories;

import com.costa.luiz.grocery.customers.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
