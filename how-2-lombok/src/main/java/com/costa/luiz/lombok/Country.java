package com.costa.luiz.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Country {

    @Id
    private Integer id;
    private String name;
    private String code;
    @Enumerated(EnumType.STRING)
    private Continent continent;

}
