package com.costa.luiz.mocks.domain;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final com.costa.luiz.mocks.domain.CustomerDAO customerDAO;

    public CustomerService(com.costa.luiz.mocks.domain.CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> findAll() {
        return customerDAO.findAllCustomers().stream()
            .map(this::toDTO)
            .collect(Collectors.toUnmodifiableList());
    }
    private Customer toDTO(CustomerEntity entity) {
        return Customer.CustomerBuilder.aCustomer()
            .withId(entity.getId())
            .withDob(entity.getDob())
            .withFullName(String.join(" ", entity.getFirstName(), entity.getMiddleName(), entity.getLastName()))
            .withFirstName(entity.getFirstName())
            .withLastName(entity.getLastName())
            .build();
    }
}
