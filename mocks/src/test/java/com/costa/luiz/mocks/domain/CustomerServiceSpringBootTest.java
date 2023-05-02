package com.costa.luiz.mocks.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CustomerServiceSpringBootTest {

    @MockBean
    private CustomerDAO customerDAO;

    @MockBean
    private ApplicationEventPublisher publisher;

    @Autowired
    CustomerService customerService;

    @Test
    void findAll() {
        var firstName = "Barry";
        var lastName = "Allen";

        doReturn(
            List.of(CustomerEntity.CustomerEntityBuilder.aCustomerEntity()
                .withFirstName(firstName)
                .withLastName(lastName)
                .build()))
            .when(customerDAO).findAllCustomers();

        var customers = customerService.findAll();

        assertThat(customers).hasSize(1)
            .extracting("firstName", "lastName")
            .contains(tuple(firstName, lastName));
    }

    @Test
    void save() {
        doNothing().when(publisher).publishEvent(any(CustomerCreatedEvent.class));

        customerService.create(Customer.CustomerBuilder.aCustomer()
                .withFirstName("Ricky")
                .withLastName("Sanchez")
            .build());

        verify(customerDAO).save(any(CustomerEntity.class));
        verify(publisher).publishEvent(any());
    }

    @TestConfiguration
    static class PublisherConfigurationMock {
        @Bean
        @Primary
        ApplicationEventPublisher publisher() {
            return mock(ApplicationEventPublisher.class);
        }
    }
}
