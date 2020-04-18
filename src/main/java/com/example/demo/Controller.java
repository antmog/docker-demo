package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * All methods are triggered by GET request for being easier to demonstrate operations using curl
 * (instead of curl -x DELETE url-> just curl url)
 * (instead of curl -x POST url-> just curl url)
 */
@RestController
public class Controller {

    @Autowired
    private CoolService coolService;

    @GetMapping("/hello")
    public String hello() {
        return coolService.sayHello();
    }

    @GetMapping("/create/{name}")
    public String createUser(@PathVariable String name) {
        return coolService.createUser(name);
    }

    @GetMapping("/get")
    public String getUserNames() {
        return coolService.getUsers();
    }

    @GetMapping("/clear")
    public void clearUsers() {
        coolService.deleteAll();
    }

}
