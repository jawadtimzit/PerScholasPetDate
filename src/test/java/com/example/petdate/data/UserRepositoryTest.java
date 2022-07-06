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
//        String name = "testname";
//        // given
//        User user = new User(name, "password", "USER");
//        // save this user
//        userRepository.save(user);
//        // when - check to find this username that has been just saved
//        User actual = userRepository.findByUsername(name);
//        // then
//        assertThat(expected).isEqualTo("testname");
    }
}