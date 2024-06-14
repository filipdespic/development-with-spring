package com.filip.springboot.demo.demoapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
}
