package io.siusoon.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.siusoon.app.user.model.User;
import io.siusoon.app.user.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping(value = "/users", params = "email")
    public User findUserByEmail( @Param("email") String userEmail) {
        return service.findOneByEmail(userEmail);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User u) {
        return service.save(u);
    }

}
