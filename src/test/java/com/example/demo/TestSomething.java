package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static com.example.demo.CoolService.HELLO_STRING;

@SpringBootTest
public class TestSomething {

    @Autowired
    CoolService helloService;
    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void init() {
        userRepository.deleteAll();
    }

    @Test
    public void testAnything() {
        String testUser = "testUser" + new Random().nextInt(15);
        helloService.createUser(testUser);

        Assertions.assertEquals(helloService.sayHello(), HELLO_STRING);
        Assertions.assertEquals(userRepository.findAll().get(0).getName(), testUser);
    }
}
