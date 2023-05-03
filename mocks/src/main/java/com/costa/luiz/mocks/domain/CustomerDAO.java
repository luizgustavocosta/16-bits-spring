package com.costa.luiz.mocks.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CustomerDAO {

    private final List<CustomerEntity> customers = new ArrayList<>();

    public List<CustomerEntity> findAllCustomers() {
        if (customers.isEmpty()) {
            CustomerEntity customer = CustomerEntity.CustomerEntityBuilder.aCustomerEntity()
                .withId(UUID.randomUUID().toString())
                .withFirstName("John")
                .withMiddleName("Axe")
                .withLastName("Doe")
                .withDob("12/31/23")
                .withPhones(List.of("202-555-0151", "202-555-0102", "202-555-0198", "202-555-0101"))
                .build();

            customers.add(customer);
        }
        return customers;
    }

    public void save(CustomerEntity entity) {
        customers.add(entity);
    }
}

