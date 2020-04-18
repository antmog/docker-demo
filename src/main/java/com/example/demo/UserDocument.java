package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
class UserDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    public UserDocument(String name) {
        this.name = name;
    }

    @Id
    private String id;

    private String name;

}