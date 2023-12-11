package com.example.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String helloworld(){
        return "hello world from Spring Boot";

    }

    @RequestMapping("/goodbye")
    public String helloWorld(){
        return "Goodbye from Spring Boot";
    }
}
