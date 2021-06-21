package com.costa.luiz.lombok;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles(profiles = "test")
class CountryControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @DisplayName("All countries")
    @Test
    @WithMockUser
    void whenRequestAllCountriesThenBringAllCountries() {
        webTestClient
                .get()
                .uri("/countries")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(3)
                .jsonPath("$[0].id").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo("Monaco")
                .jsonPath("$[0].continent").isEqualTo(Continent.EUROPE.name())
                .jsonPath("$[2].id").isEqualTo(3)
                .jsonPath("$[2].name").isEqualTo("Andorra")
                .jsonPath("$[2].continent").isEqualTo(Continent.EUROPE.name());
    }
}