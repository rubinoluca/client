package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String getStudents()
    {

        final String uri = "https://producer-testapp.apps-crc.testing/hello";

        String result = "";
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
            return result;
        }
        catch (Exception e){
            return result;
        }

    }
    @GetMapping("/test")
    public String sendGreetings() {
        return "Il consumer funziona!";
    }
}
