package com.springboot.testingIntellij.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
public class Person {

    private final UUID id;
    //you could make an annotation @NotBlank to throw an error if: name: " ".
    private final String name;

    //@JsonProperty so that we can identify the variables them with the POST request.
    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}