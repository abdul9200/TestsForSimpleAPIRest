package com.example.demo.Controller;

import com.example.demo.Service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WelcomeControllerUnitTest {
    @Test
    void shouldWelcome(){
        WelcomeService welcomeService= Mockito.mock(WelcomeService.class);
        when(welcomeService.getWelecomeMessage("said")).thenReturn("Welcome said!");
        WelcomeController welcomeController = new WelcomeController(welcomeService);
        assertEquals("Welcome said!",welcomeController.welcome("said"));
    }

}