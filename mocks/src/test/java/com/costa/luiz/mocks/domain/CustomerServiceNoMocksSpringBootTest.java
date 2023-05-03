package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceNoMocksSpringBootTest {

    @Autowired
    CustomerService customerService;

    @Test
    @Order(1)
    void findAll() {
        var firstName = "John";
        var lastName = "Doe";

        var customers = customerService.findAll();

        assertThat(customers).hasSize(1)
            .extracting("firstName", "lastName")
            .contains(tuple(firstName, lastName));
    }

    @Test
    @Order(2)
    void create() {
        customerService.create(Customer.CustomerBuilder.aCustomer()
            .withFirstName("Clark")
            .withLastName("Kent")
            .build());

        var customers = customerService.findAll();
        assertThat(customers).hasSize(2);
    }
}
