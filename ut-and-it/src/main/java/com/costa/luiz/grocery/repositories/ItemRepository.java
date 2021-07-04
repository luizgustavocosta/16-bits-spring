package com.costa.luiz.grocery.repositories;

import com.costa.luiz.grocery.orders.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
