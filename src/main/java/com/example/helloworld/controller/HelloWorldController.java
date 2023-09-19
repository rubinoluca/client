package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;


@RestController
public class HelloWorldController {

    @GetMapping("/getstudents")
    public String getStudents()
    {
        final String uri = "http://10.217.4.168:8080/students";

        String result = "stringa vuota";
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
            return "str: " + result;
        }
        catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            return "str EXCEPTION: " + errors.toString(); // Ritorna il risultato che stamperebbe e.printStackTrace()
        }
    }

    @GetMapping("/gethello")
    public String getHello()
    {

        final String uri = "http://10.217.4.168:8080/hello";

        String result = "stringa vuota";
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
            return "str: " + result;
        }
        catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            return "str EXCEPTION: " + errors.toString(); // Ritorna il risultato che stamperebbe e.printStackTrace()
        }

    }
    @GetMapping("/test")
    public String sendGreetings() {
        return "Il consumer funziona";
    }
}
