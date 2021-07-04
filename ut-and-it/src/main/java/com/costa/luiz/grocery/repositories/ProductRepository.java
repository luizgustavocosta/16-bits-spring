package com.costa.luiz.grocery.repositories;

import com.costa.luiz.grocery.products.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
