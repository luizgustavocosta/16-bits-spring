package com.costa.luiz.profile.domain;

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

    public FictionalCharacter(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
