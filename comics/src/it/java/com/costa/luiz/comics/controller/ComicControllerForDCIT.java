package com.costa.luiz.comics.controller;

import com.costa.luiz.comics.AppMain;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AppMain.class)
@AutoConfigureWebTestClient
@ActiveProfiles(profiles = "dc")
class ComicControllerForDCIT {

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("DC profile")
    void characters() throws Exception {
        var serverResponse = given()
            .baseUri("http://localhost:" + port)
            .auth()
            .basic("tomking", "tomking")
            .when()
            .get("/comics/stories/characters")
            .then().log()
            .body()
            .statusCode(HttpStatus.SC_OK)
            .extract().asString();

        assertThat(serverResponse)
            .contains("Superman,Batman,Wonder Woman,Green lantern,Nightwing,Flash,Catwoman,Shazan");
    }
}

