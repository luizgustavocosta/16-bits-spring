package com.costa.luiz.domain.grocery.repository;

import com.costa.luiz.domain.grocery.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
