package com.costa.luiz.lombok;

import com.costa.luiz.lombok.annotations.UnitTest;
import org.force66.beantester.BeanTester;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Country")
class CountryTest {

    @UnitTest
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

    @UnitTest
    void testProperties() {
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Country.class);
        beanTester.testBean(Country.class, new Object[]{42, "", "", Continent.AFRICA});
        assertNotNull(Country.builder().build().toString());
    }

    @UnitTest
    void testBuilder() {
        Country.CountryBuilder builder = Country.builder().id(42).code("TV").name("Tuvalu").continent(Continent.ANTARCTIC);
        assertNotNull(builder.toString());
        assertNotNull(builder.build());
    }
}