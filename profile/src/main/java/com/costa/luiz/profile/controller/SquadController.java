package com.costa.luiz.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SquadController {

    @GetMapping("/hello")
    public String hello(Principal principal) {
        if (principal == null) {
            return "";
        }
        return "Hello "+principal.getName();
    }
}
