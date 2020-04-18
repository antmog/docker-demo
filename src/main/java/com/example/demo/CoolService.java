package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CoolService {

    public static final String HELLO_STRING = "Hello!";

    private static final String USER_REPRESENTATION_TEMPLATE = "<p>%s:%s</p>";

    @Autowired
    private UserRepository userRepository;


    public String sayHello() {
        return HELLO_STRING;
    }

    public String createUser(String name) {
        return createUserRepresentation(userRepository.save(new UserDocument(name)));
    }

    public String getUsers() {
        return userRepository.findAll().stream()
                .map(this::createUserRepresentation)
                .collect(Collectors.joining("\n"));
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    private String createUserRepresentation(UserDocument user) {
        return String.format(USER_REPRESENTATION_TEMPLATE, user.getId(), user.getName());
    }
}
