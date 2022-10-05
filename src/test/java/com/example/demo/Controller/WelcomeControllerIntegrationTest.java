package com.example.demo.Controller;

import com.example.demo.Service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WelcomeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WelcomeService welcomeService;
    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        when(welcomeService
                .getWelecomeMessage("Stranger"))
                .thenReturn("Welcome Stranger!");
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("Welcome Stranger!")));
        verify(welcomeService).getWelecomeMessage("Stranger");
    }
    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        when(welcomeService
                .getWelecomeMessage("Said"))
                .thenReturn("Welcome Said!");
        mockMvc.perform(get("/welcome?name=Said"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("Welcome Said!")));
        verify(welcomeService).getWelecomeMessage("Said");
    }

}