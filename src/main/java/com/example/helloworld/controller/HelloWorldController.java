package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String getStudents()
    {
        System.out.println("1");
        final String uri = "https://test-git-testapp.apps-crc.testing/hello";
        System.out.println("2");
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("3");
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("4");
        return result;
    }
    @GetMapping("/hello")
    public String sendGreetings() {
        return "Il client funziona!";
    }
}
