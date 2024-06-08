package com.example.helloworld;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController




public class HelloworldApplication {

        public static void main(String[] args) {
                SpringApplication.run(HelloworldApplication.class, args);
        }



    @RequestMapping("/")
    public String helloworld(){
        return "hello world from Spring Boot";

    }

    @RequestMapping("/goodbye")
    public String helloWorld(){
        return "Goodbye from Spring Boot";
    }



}
