package com.costa.luiz.domain.grocery.repository;

import com.costa.luiz.domain.grocery.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
