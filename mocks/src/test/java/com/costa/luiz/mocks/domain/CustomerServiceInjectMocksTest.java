package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
class CustomerServiceInjectMocksTest {

    @Mock
    private CustomerDAO customerDAO;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // or use the annotation @ExtendWith(MockitoExtension.class) at class level
    }

    @Test
    void findAll() {
        when(customerDAO.findAllCustomers())
            .thenReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()));
        var customers = customerService.findAll();
        assertNotNull(customers);
    }

    @Test
    void create() {
        customerService.create(Customer.CustomerBuilder.aCustomer().withFirstName("Clark").build());
        verify(applicationEventPublisher).publishEvent(any());
    }
}
