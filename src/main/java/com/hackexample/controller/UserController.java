package com.hackexample.controller;

import com.hackexample.model.User;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller("/user")
public class UserController {

    @Get
    public Iterable<User> getAllUsers() {
        List<User> allUsers = Arrays.asList(
                new User().id(1L).name("ace"),
                new User().id(2L).name("bob"),
                new User().id(3L).name("cat")
        );
        return allUsers;
    }

    @Get("/{id}")
    public User getUserById(@PathVariable long id) {
        return new User().id(id).name("another name");
    }
}
