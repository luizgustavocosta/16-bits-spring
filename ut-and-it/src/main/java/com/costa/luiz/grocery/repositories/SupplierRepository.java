package com.costa.luiz.grocery.repositories;

import com.costa.luiz.grocery.suppliers.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
