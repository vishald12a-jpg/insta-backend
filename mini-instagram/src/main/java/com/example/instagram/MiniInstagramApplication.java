package com.example.instagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniInstagramApplication {

    public static void main(String[] args) {

        SpringApplication.run(MiniInstagramApplication.class, args);

        System.out.println("Mini Instagram Application Started");
    }
}