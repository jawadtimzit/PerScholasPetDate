package com.example.petdate.service;

import com.example.petdate.data.AdminDogRepository;
import com.example.petdate.model.Dog;
import com.example.petdate.service.AdminDogService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminDogServiceTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AdminDogRepository adminDogRepository;

    @Test
    @Order(2)
    @DisplayName("Test save dog")
    public void saveDog(){
        Dog expected = new Dog("Poodle","Teddy",10,"female","Teddypoddle@hotmail.com","https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg","This female teddy");
        Dog actual = new Dog("Poodle","Teddy",10,"female","Teddypoddle@hotmail.com","https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg","This female teddy");
        adminDogRepository.save(expected);
        adminDogRepository.save(actual);
        Assertions.assertEquals(expected,actual);

//        Dog dog = new Dog("Poodle","Teddy",10,"female","Teddypoddle@hotmail.com","https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg","This female teddy");
//        entityManager.persistAndFlush(dog);
//        assertThat(dog.getId()).isNotNull();
    }
}
