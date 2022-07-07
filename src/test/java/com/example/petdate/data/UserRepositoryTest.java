package com.example.petdate.data;

import com.example.petdate.model.Dog;
import com.example.petdate.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Test find by Username: it should check if user exist")
    void findByUsername() {

        // create a user
        User user = new User("testname","password","USER");
        // save the user
        userRepository.save(user);
        //
        String name = "testname";
        User object = userRepository.findByUsername(name); // assign name to object
        assertThat(object.getUsername()).isEqualTo(name); // check if object name is equal to username
    }

}