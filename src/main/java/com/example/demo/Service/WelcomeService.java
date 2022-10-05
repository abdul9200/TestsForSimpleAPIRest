package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String getWelecomeMessage(String name){
        return String.format("Welcome %s!",name);
    }
}
