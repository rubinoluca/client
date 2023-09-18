package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    private static void getStudents()
    {
        final String uri = "http://10.217.4.86/students";
    
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
    
        System.out.println(result);
    }
    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }
}
