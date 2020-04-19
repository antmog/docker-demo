package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoolService {

    static final String HELLO_STRING = "Hello!";

    private static final String USER_REPRESENTATION_TEMPLATE = "<p>%s:%s</p>";
    private static final String NO_USERS_CREATED = "No users created";

    @Autowired
    private UserRepository userRepository;


    String sayHello() {
        return HELLO_STRING;
    }

    String createUser(String name) {
        return createUserRepresentation(userRepository.save(new UserDocument(name)));
    }

    String getUsers() {
        List<UserDocument> users = userRepository.findAll();
        return users.isEmpty() ? NO_USERS_CREATED : users.stream()
                .map(this::createUserRepresentation)
                .collect(Collectors.joining("\n"));
    }

    void deleteAll() {
        userRepository.deleteAll();
    }

    private String createUserRepresentation(UserDocument user) {
        return String.format(USER_REPRESENTATION_TEMPLATE, user.getId(), user.getName());
    }
}
