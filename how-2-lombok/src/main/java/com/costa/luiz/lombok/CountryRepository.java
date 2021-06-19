package com.costa.luiz.lombok;

import org.springframework.data.repository.CrudRepository;

interface CountryRepository extends CrudRepository<Country, Integer> {}
