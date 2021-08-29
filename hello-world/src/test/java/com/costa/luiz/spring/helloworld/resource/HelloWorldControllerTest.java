package com.costa.luiz.spring.helloworld.resource;

import com.costa.luiz.spring.helloworld.AppMainConfig;
import com.costa.luiz.spring.resource.HelloWorldController;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = HelloWorldController.class)
@ContextConfiguration(classes = AppMainConfig.class)
class HelloWorldControllerTest implements WithAssertions {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/spring/helloworld")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello user")));
    }

    @Test
    @WithMockUser
    void shouldReturnACustomizedMessage() throws Exception {
        this.mockMvc.perform(
                get("/api/spring/helloworld/16-bits"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Spring saying 'Hello to")));
    }



}
