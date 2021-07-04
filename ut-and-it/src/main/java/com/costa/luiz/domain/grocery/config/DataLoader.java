package com.costa.luiz.domain.grocery.config;

import com.costa.luiz.domain.grocery.model.*;
import com.costa.luiz.domain.grocery.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collections;

@Configuration
public class DataLoader {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    CommandLineRunner initDatabase(SupplierRepository supplierRepository,
                                   ProductRepository productRepository,
                                   ItemRepository itemRepository,
                                   OrderRepository orderRepository,
                                   CustomerRepository customerRepository) {

        return args -> {
            var supplier = supplierRepository.save(Supplier.builder().country("Spain").name("El Toro").build());
            var product = productRepository.save(Product.builder().supplier(supplier).name("Red Wine").price(BigDecimal.TEN).build());
            var order = Order.builder().comments("Delivery after noon").status(Status.OPEN)
                    .build();
            orderRepository.save(order);

            Item item = Item.builder()
                    .product(product)
                    .quantity(10)
                    .build();

            itemRepository.save(item);

            order.setItems(Collections.singletonList(item));
            orderRepository.save(order);

            var customer = Customer.builder().customerContact(CustomerContact.builder()
                    .address("Avingunda Diagonal")
                    .city("Barcelona")
                    .phone("123-456")
                    .build())
                    .firstName("Luiz")
                    .lastName("Costa")
                    .dob(LocalDate.MIN)
                    .comments("Prime client")
                    .build();

            customer.addOrder(order);

            customerRepository.save(customer);

            log.info("Loaded data has been finished");
        };
    }
}