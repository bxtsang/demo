package com.hackexample.controller;

import com.hackexample.model.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class UserControllerTest {

    @Inject
    @Client("/")
    public HttpClient client;

    @Test
    public void testGetAllUsers() {
        User[] users = client.toBlocking().retrieve("/user", User[].class);

        assertTrue(users.length > 0);
    }

    @Test
    public void testGetUserById() {
        User user = client.toBlocking().retrieve("/user/1", User.class);
        assertEquals(1L, user.getId());
        assertEquals("ace", user.getName());
    }
}
