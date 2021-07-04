package com.costa.luiz.grocery.customers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CustomerContact {

    private String phone;
    private String email;
    private String address;
    private String city;
}
