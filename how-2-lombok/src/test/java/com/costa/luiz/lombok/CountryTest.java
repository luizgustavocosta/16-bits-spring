package com.costa.luiz.lombok;

import org.force66.beantester.BeanTester;
import org.force66.beantester.BeanTesterConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Country")
class CountryTest {

    @Test
    void whenSendTheDataThenBuildACountry() {
        Country country = Country.builder()
                .id(99)
                .code("AR")
                .continent(Continent.SOUTH_AMERICA)
                .name("Argentina")
                .build();

        assertThat(country)
                .isNotNull()
                .extracting("id", "code", "continent", "name")
                .isNotNull();
    }

    @Test
    void testProperties() {
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Country.class);
        beanTester.testBean(Country.class, new Object[]{42, "", "", Continent.AFRICA});
    }
}