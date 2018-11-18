package com.asg360;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Task360Application {

    public static void main(String[] args) {
        SpringApplication.run(Task360Application.class, args);
    }
    
    @GetMapping("/")
    public String showMe(){
        return "It's work!!!";
    }

}
