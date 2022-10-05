package com.example.demo.Controller;

import com.example.demo.Service.WelcomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    WelcomeService welcomeService;
    public WelcomeController (WelcomeService welcomeService){
        this.welcomeService=welcomeService;
    }
    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "Stranger") String name){
        return welcomeService.getWelecomeMessage(name);
    }
}
