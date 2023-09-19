package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String getStudents()
    {
        final String uri = "https://10.217.4.86/hello";
    
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        //return result;
        //System.out.println(result);
        return result;
    }
    @GetMapping("/hello")
    public String sendGreetings() {
        return "Il client funziona!";
    }
}
