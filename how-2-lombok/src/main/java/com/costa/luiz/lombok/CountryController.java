package com.costa.luiz.lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
@Slf4j
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
        var countries = service.findAll();
        log.info("Received {} countries", countries.size());
        return countries.stream().map(mapper::map).collect(Collectors.toUnmodifiableList());
    }
}


