package com.costa.luiz.domain.grocery.repository;

import com.costa.luiz.domain.grocery.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
