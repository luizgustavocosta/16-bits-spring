package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceInjectMocksTest {

    @Mock
    private CustomerDAO customerDAO;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void findAll() {
        when(customerDAO.findAllCustomers())
            .thenReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()));
        var customers = customerService.findAll();
        assertNotNull(customers);
    }

    @Test
    void save() {
        customerService.create(Customer.CustomerBuilder.aCustomer().withFirstName("Clark").build());
        verify(applicationEventPublisher).publishEvent(any());
    }
}
