package com.costa.luiz.spring.quizz.jpa;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/quiz/transaction")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public Person createPersonBy(@RequestBody String name) {
        Person person = service.create(name);
        return service.findOne(person.getId());
    }

    @GetMapping
    @ResponseBody
    public List<Person> allPeople() {
        return service.findAll();
    }
}
