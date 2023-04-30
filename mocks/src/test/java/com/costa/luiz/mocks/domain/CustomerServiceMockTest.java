package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceMockTest {

    @Mock
    CustomerDAO customerDAO;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerDAO);
    }

    @Test
    void findAll() {
        //when(customerDAO.findAllCustomers()).thenReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()));
        doReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()))
            .when(customerDAO).findAllCustomers();
        var customers = customerService.findAll();
        assertNotNull(customers);
    }
}
