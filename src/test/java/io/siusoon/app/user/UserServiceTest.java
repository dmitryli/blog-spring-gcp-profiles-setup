package io.siusoon.app.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.siusoon.app.user.model.User;
import io.siusoon.app.user.service.UserService;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void createReadUpdateUser() {
        LocalDateTime now = LocalDateTime.now();
        String email = now.toString().concat("@useremail.com");

       
        User u = User.builder()
                .firstName("Test")
                .middleName("NMN")
                .lastName("TestLastName")
                .email(email)
                .build();

        var result = service.save(u);
        assertNotNull(result.getId());
        assertEquals(u.getEmail(), result.getEmail());

        var findOne = service.findOneByEmail(email);

        findOne.setFirstName("NewTest");
        findOne.setLastName("NewLastName");

        service.save(findOne);

        assertEquals(findOne.getId(), result.getId());
        assertEquals(findOne.getEmail(), result.getEmail());
        assertEquals(findOne.getFirstName(), "NewTest");
        assertEquals(findOne.getLastName(), "NewLastName");

    }

   
}
