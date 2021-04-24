package com.costa.luiz.spring.quizz.jpa;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/quiz/transaction")
public class PersonController {

    private final PersonService service;
    private final OtherPersonService innerService;

    public PersonController(PersonService service, OtherPersonService innerService) {
        this.service = service;
        this.innerService = innerService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "{use}/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Person createPersonBy(@PathVariable boolean use,
                                 @PathVariable String name) {
        Person person = null;
        if (use) {
            return service.createUsingTransaction(name);
        } else {
            return innerService.create(name);
        }
    }


}
