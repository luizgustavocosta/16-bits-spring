package com.costa.luiz.domain.grocery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private ZonedDateTime lastUpdate;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dob;
    private String comments;
    @Embedded
    private CustomerContact customerContact;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> orders;

    public void addOrder(Order order) {
        if (isNull(orders)) {
            orders = new ArrayList<>();
        }
        //Mutable
        orders.add(order);
    }
}
