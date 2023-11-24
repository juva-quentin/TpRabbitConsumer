package com.quentin.tprabbitmqconsumer.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class User implements Serializable {
    private String username;
    private String email;

    public User() {}
}

