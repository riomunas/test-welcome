package com.domain.test_welcome.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String getWelcomeMessage(){
        return "Welcome from the testing!";
    }
}
