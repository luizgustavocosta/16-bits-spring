package com.costa.luiz.lombok;

import com.costa.luiz.lombok.annotations.UnitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ActiveProfiles(profiles = "test")
class CountryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CountryService service;

    @MockBean
    CountryMapper mapper;

    @UnitTest
    @WithMockUser
    void whenRequestAllThenBringAllCountries() throws Exception {
        var id = 42;
        var country = Country.builder().id(id).build();
        when(service.findAll()).thenReturn(Collections.singletonList(country));

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(id);
        when(mapper.map(country)).thenReturn(countryDTO);

        this.mockMvc.perform(get("/countries"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(countries()));
    }

    private String countries() {
        return "[{\"id\":42,\"name\":null,\"code\":null,\"continent\":null}]";
    }
}