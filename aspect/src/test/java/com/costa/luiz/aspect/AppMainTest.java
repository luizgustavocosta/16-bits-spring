package com.costa.luiz.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppMainTest {

    @Autowired
    DomainService service;

    @Autowired
    CustomerService otherService;

    @Autowired
    CustomerRepository repository;

    @Test
    void testGetDomainObjectById() {
        service.findBy(10L);
        assertThrows(UnsupportedOperationException.class, () -> otherService.create());
    }

    @Test
    void testAspectBefore() {
        findAndDelete();
    }

    @Test
    void testAspectAfter() {
        findAndDelete();
    }

    @Test
    void testAspectAround() {
        final boolean created = repository.create("Mando");
        assertTrue(created);
    }

    @Test
    void testAspectAfterReturning() {
        final Stream<String> stream = repository.findAll();
        assertNotNull(stream);
    }

    private void findAndDelete() {
        String magicNumber = "42";
        final String customer = repository.findBy(magicNumber);
        final boolean isDeleted = repository.delete(Integer.parseInt(magicNumber));
        assertAll(() -> {
            assertNotNull(customer);
            assertTrue(isDeleted);
        });
    }
}