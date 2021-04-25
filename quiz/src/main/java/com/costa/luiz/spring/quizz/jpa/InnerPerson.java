package com.costa.luiz.spring.quizz.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InnerPerson {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public InnerPerson(){}

    public InnerPerson(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InnerPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
