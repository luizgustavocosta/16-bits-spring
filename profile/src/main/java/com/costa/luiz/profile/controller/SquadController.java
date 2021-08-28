package com.costa.luiz.profile.controller;

import com.costa.luiz.profile.domain.Squad;
import com.costa.luiz.profile.domain.SquadService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.stream.Collectors;

@RestController
public class SquadController {

    private final SquadService service;

    public SquadController(SquadService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello(Principal principal) {
        if (principal == null) {
            return "";
        }
        return "Hello " + principal.getName();
    }

    @GetMapping("/squads")
    public String viewAll(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String squad = service.findAll().stream().map(Squad::getName).collect(Collectors.joining(","));
        return "User has authorities: " + userDetails.getAuthorities() + "\n" +
            "This is the squad \n" + squad;
    }
}
