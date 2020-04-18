package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public static final String HELLO_STRING = "Hello!";

    public String sayHello() {
        return HELLO_STRING;
    }
}
