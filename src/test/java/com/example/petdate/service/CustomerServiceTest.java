package com.example.petdate.service;

import com.example.petdate.data.CustomerDogRepository;
import com.example.petdate.model.Address;
import com.example.petdate.model.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerDogRepository customerDogRepository;

    @DisplayName("Test to find all dog by customer")
    @Test
    void findAllDogsByCustomer() {

        // given - dogs to save

        Address a1 = new Address();
        a1.setStreetName("24th Ave NW");a1.setHouseNum(2345);a1.setCity("Seattle");a1.setState("WA");a1.setZipCode(23000);
        Dog dog1 = new Dog("Poodle", "Teddy", 10, "female", "Teddypoddle@hotmail.com", "https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg", "This female teddy", a1);

        Address a2 = new Address();
        a2.setStreetName("20Ave nw");a2.setHouseNum(1312);a2.setCity("Lynwood");a2.setState("WA");a2.setZipCode(12000);
        Dog dog2 = new Dog("Shphered", "Max", 15, "male", "max@hotmail.com", "https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg", "This female teddy", a2);

        // save both dogs
        customerDogRepository.save(dog1);
        customerDogRepository.save(dog2);

        // when- testing here dogs by storing them in a list
        List<Dog> dogList = customerDogRepository.findAll();

        // then - lets verify that the doglist is not null and expected to be two dogs
        // H2 is down There is 28 dogs that are inserted from the main runner
        assertThat(dogList).isNotNull();
        assertThat(dogList.size()).isEqualTo(32); // 28 in databse created in main runner + 2 now = 30
        // I added 2 in other test that are not deleted
    }

}