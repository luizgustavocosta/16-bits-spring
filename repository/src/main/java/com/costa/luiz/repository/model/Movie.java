package com.costa.luiz.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    private String id;
    private String name;
    private String year;
}
