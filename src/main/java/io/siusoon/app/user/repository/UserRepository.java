package io.siusoon.app.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.siusoon.app.user.model.User;


/*
 * Dima: this technique is using method name reflection and creates a query behind it
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    
    public User findOneByEmail(String userEmail);

    public User findByLastName(String lastName);

}
