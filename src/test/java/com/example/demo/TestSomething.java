package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.HelloService.HELLO_STRING;

@SpringBootTest
public class TestSomething {

    @Autowired
    HelloService helloService;

    @Test
    public void testAnything() {
        Assertions.assertEquals(helloService.sayHello(), HELLO_STRING);
    }
}
