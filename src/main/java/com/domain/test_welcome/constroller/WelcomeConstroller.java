package com.domain.test_welcome.constroller;

import com.domain.test_welcome.services.WelcomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class WelcomeConstroller {
    private final WelcomeService welcomeService;

    @Autowired
    public WelcomeConstroller(WelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return welcomeService.getWelcomeMessage();
    }
    
    
}
