package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;
import java.time.LocalDateTime;


@SpringBootApplication
@RestController

public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

            @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

                    LocalDateTime currentTime = LocalDateTime.now();

      return String.format("Hello  %s! " + currentTime, name);
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
