package com.costa.luiz.domain.grocery.model;

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
