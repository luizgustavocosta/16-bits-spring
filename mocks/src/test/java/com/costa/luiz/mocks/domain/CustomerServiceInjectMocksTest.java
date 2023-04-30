package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceInjectMocksTest {

    @Mock
    private CustomerDAO customerDAO;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        when(customerDAO.findAllCustomers())
            .thenReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()));
        var customers = customerService.findAll();
        assertNotNull(customers);
    }
}
