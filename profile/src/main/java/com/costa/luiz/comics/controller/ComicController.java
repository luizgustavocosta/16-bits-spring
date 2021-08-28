package com.costa.luiz.comics.controller;

import com.costa.luiz.comics.domain.FictionalCharacter;
import com.costa.luiz.comics.domain.CharacterService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RestController
public class ComicController {

    private final CharacterService service;

    public ComicController(CharacterService service) {
        this.service = service;
    }

    @GetMapping("/preview")
    public String preview(Principal principal) {
        if (isNull(principal)) {
            return "";
        }
        return "Hey " + principal.getName() + " this is a preview of comics.";
    }

    @GetMapping("/characters")
    public String characters(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "Hi writer " + userDetails.getUsername() +
            ", please use following heroes: " +
            service.findAll().stream().map(FictionalCharacter::getName).collect(Collectors.joining(","));
    }
}
