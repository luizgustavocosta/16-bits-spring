package com.costa.luiz.stream_and_list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

@DisplayName("Client Resource")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientResourceTest {

    @Autowired
    private ClientResource controller;

    @LocalServerPort
    private int port;

    @Test
    void byList() {
        LocalDateTime start = LocalDateTime.now();
        controller.findAll();
        System.out.println("Duration.between(start, LocalDateTime.now()) = " + Duration.between(start, LocalDateTime.now()));
    }

    @Test
    void byStream() {
        final LocalDateTime start = LocalDateTime.now();

        controller.findAllInStreamMode();

        System.out.println("Duration.between(start, LocalDateTime.now()) = " + Duration.between(start, LocalDateTime.now()));
    }
}