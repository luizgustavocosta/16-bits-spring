package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CustomerServiceMockTest {

    @Mock
    CustomerDAO customerDAO;
    CustomerService customerService;
    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerDAO, null);
    }

    @Test
    void findAll() {
        doReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()))
            .when(customerDAO).findAllCustomers();

        var customers = customerService.findAll();

        assertNotNull(customers);
    }
}
