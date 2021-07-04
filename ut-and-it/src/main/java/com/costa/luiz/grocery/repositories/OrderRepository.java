package com.costa.luiz.grocery.repositories;

import com.costa.luiz.grocery.orders.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
