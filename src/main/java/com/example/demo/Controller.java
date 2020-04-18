package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * All methods are triggered by GET request for being easier to demonstrate operations using curl
 * (instead of curl -x DELETE url-> just curl url)
 * (instead of curl -x POST url-> just curl url)
 */
@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }

    @GetMapping("/create/{name}")
    public String createUser(@PathVariable String name) {
        return userRepository.save(new UserDocument(name)).getName();
    }

    @GetMapping("/get")
    public String getUserNames() {
        return userRepository.findAll().stream()
                .map(this::createUserRepresentation)
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("/clear")
    public void clearUsers() {
        userRepository.deleteAll();
    }

    private static final String USER_REPRESENTATION_TEMPLATE = "%s:%s";

    private String createUserRepresentation(UserDocument user) {
        return String.format(USER_REPRESENTATION_TEMPLATE, user.getId(), user.getName());
    }
}
