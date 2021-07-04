package com.costa.luiz.domain.grocery.repository;

import com.costa.luiz.domain.grocery.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
