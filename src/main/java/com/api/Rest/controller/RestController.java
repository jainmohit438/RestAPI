package com.api.Rest.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Welcome to my Page aa";
    }
}
