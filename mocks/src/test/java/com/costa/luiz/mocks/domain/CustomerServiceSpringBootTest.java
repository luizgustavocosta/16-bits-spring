package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class CustomerServiceSpringBootTest {

    @MockBean
    private CustomerDAO customerDAO;

    @Autowired
    CustomerService customerService;

    @Test
    void findAll() {
        var customers = customerService.findAll();
        assertNotNull(customers);
    }

}
