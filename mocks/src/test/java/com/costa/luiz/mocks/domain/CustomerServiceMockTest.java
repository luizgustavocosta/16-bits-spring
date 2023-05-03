package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class CustomerServiceMockTest {

    @Mock
    CustomerDAO customerDAO;

    @Mock
    ApplicationEventPublisher publisher;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerService(customerDAO, publisher);
    }

    @Test
    void findAll() {
        doReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()))
            .when(customerDAO).findAllCustomers();

        var customers = customerService.findAll();

        assertNotNull(customers);
    }

    @Test
    void create() {
        doReturn(List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity().build()))
            .when(customerDAO).findAllCustomers();

        customerService.create(Customer.CustomerBuilder.aCustomer()
                .withFirstName("Steve")
                .withLastName("Rodgers")
            .build());

        verify(publisher).publishEvent(any(CustomerCreatedEvent.class));

        ArgumentCaptor<CustomerEntity> entityArgumentCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerDAO).save(entityArgumentCaptor.capture());

        assertNotNull(entityArgumentCaptor.getValue());
        assertThat(entityArgumentCaptor.getValue())
            .extracting("id", "firstName", "lastName")
            .doesNotContainNull();
    }
}
