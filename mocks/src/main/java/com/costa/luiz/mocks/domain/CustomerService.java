package com.costa.luiz.mocks.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;
    private final ApplicationEventPublisher publisher;

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService(CustomerDAO customerDAO, ApplicationEventPublisher publisher) {
        this.customerDAO = customerDAO;
        this.publisher = publisher;
    }

    public List<Customer> findAll() {
        return customerDAO.findAllCustomers().stream()
            .map(this::toDTO)
            .collect(Collectors.toUnmodifiableList());
    }

    public void create(Customer customer) {
        CustomerEntity entity = toANewEntity(customer);
        customerDAO.save(entity);
        publishCreatedEventFor(entity);
    }

    private void publishCreatedEventFor(CustomerEntity entity) {
        String payload = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            payload = mapper.writeValueAsString(entity);
        } catch (JsonProcessingException exception) {
            logger.error(exception.getMessage(), exception);
        }
        publisher.publishEvent(new CustomerCreatedEvent(this, Clock.systemUTC(), payload));
    }

    private CustomerEntity toANewEntity(Customer customer) {
        return CustomerEntity.CustomerEntityBuilder.aCustomerEntity()
            .withId(UUID.randomUUID().toString())
            .withDob(customer.getDob())
            .withFirstName(customer.getFirstName())
            .withLastName(customer.getLastName())
            .build();
    }

    private Customer toDTO(CustomerEntity entity) {
        return Customer.CustomerBuilder.aCustomer()
            .withId(entity.getId())
            .withDob(entity.getDob())
            .withFirstName(entity.getFirstName())
            .withLastName(entity.getLastName())
            .build();
    }
}
