package com.costa.luiz.lombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private final CountryService service;

    @Autowired
    private final CountryMapper mapper;

    public CountryController(CountryService service, CountryMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CountryDTO> allCountries() {
        return service.findAll().stream().map(mapper::map).collect(Collectors.toUnmodifiableList());
    }
}


