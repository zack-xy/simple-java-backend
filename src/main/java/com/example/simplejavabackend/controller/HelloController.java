package com.example.simplejavabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/java-api/hello")
    public String hello() {
        return "Hello Java! Day 1 project is running";
    }
}
