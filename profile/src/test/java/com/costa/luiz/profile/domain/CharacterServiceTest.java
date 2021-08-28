package com.costa.luiz.profile.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Character Service")
@ExtendWith(MockitoExtension.class)
class CharacterServiceTest {

    @Mock
    FictionalCharacterRepository repository;

    CharacterService service;

    @BeforeEach
    void setUp() {
        service = new CharacterService(repository);
    }

    @Test
    @DisplayName("Find all characters")
    void findAll() {
        when(repository.findAll()).thenReturn(Collections.singletonList(new FictionalCharacter("Chaves")));
        assertThat(service.findAll()).isNotEmpty();
    }
}
