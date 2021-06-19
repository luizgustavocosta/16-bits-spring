package com.costa.luiz.lombok;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Country Mapper")
class CountryMapperTest {

    @Test
    void whenReceiveACountryThenMapToCountryDTO() {
        //Give
        Country country = Country.builder()
                .id(10)
                .name("Germany")
                .code("DE")
                .continent(Continent.EUROPE)
                .build();
        // When
        CountryDTO countryDTO = CountryMapper.INSTANCE.map(country);

        //Then
        assertThat(country.getContinent())
                .isEqualTo(Continent.valueOf(countryDTO.getContinent()));

        assertThat(country).usingRecursiveComparison()
                .ignoringFields("continent")
                .isEqualTo(countryDTO);
    }
}