package com.matloga.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "ChallengeApp is running. Use /challenges for the API.";
    }
}
