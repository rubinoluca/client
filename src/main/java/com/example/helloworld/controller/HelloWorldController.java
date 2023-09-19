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
        return consume_API("students");
    }

    @GetMapping("/gethello")
    public String getHello()
    {
        return consume_API("hello");
    }

    public String consume_API(String page){

        final String uri = "http://10.217.4.168:8080/" + page;                          // Funziona!
        // final String uri = "https://10.217.4.168:8080/" + page;                      // Non funziona! Errore certificato SSL
        // final String uri = "https://producer-git-testapp.apps-crc.testing/" + page;  // Non funziona! Errore certificato SSL
        // final String uri = "http://producer-git-testapp.apps-crc.testing/" + page;   // Non funziona! Stampa: "str: null"

        String result = "stringa vuota";
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
            return "str: " + result;
        }
        catch (Exception e){
            return "str EXCEPTION: " + convert_printstackTrace_to_str(e);
        }
    }

    public String convert_printstackTrace_to_str(Exception e){
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

    @GetMapping("/")
    public String sendGreetings() {
        return "Il consumer funziona.";
    }
}
