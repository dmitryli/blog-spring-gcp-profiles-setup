package io.siusoon.app.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.siusoon.app.user.model.User;
import io.siusoon.app.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findOneByEmail(String userEmail) {
        return repository.findOneByEmail(userEmail);
    }

    public User findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public User save(User user) {

        var result = repository.save(user);

        log.info("User {} was saved with id {}", result.getEmail(), result.getId());

        return result;
    }

   

}