package org.kreoin.shorturl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(path = "")
    public String welcome() {
        return "Welcome to URL shortener app";
    }
}
