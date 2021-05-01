package com.costa.luiz.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AppMainTest {

    @Autowired
    DomainService service;

    @Autowired
    Customer otherService;

    @Test
    public void testGetDomainObjectById() {
        service.findBy(10L);
        assertThrows(UnsupportedOperationException.class, () -> otherService.create());
    }
}