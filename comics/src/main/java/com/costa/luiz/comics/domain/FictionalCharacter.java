package com.costa.luiz.comics.domain;

import javax.persistence.*;

@Entity
@Table(name = "fictionalCharacters")
public class FictionalCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public FictionalCharacter() {
    }

    public FictionalCharacter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
