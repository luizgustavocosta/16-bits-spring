package com.costa.luiz.lombok;

import com.costa.luiz.lombok.annotations.UnitTest;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Country Mapper")
class CountryMapperTest {

    @UnitTest
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

    @UnitTest
    void whenReceiveANullEntityThenReturnNull() {
        var countryDTO = CountryMapper.INSTANCE.map(null);
        assertThat(countryDTO).isNull();
    }
}