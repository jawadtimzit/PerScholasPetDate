package com.example.petdate.data;

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
class CustomerDogRepositoryTest {

    @Autowired
    CustomerDogRepository customerDogRepository;

    @DisplayName("Test get breed")
    @Test
    void getBreed() {
        Address a1 = new Address();
        a1.setStreetName("24th Ave NW");a1.setHouseNum(2345);a1.setCity("Seattle");a1.setState("WA");a1.setZipCode(23000);

        Dog dog = new Dog("Poodle", "Teddy", 10, "female", "Teddypoddle@hotmail.com", "https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg", "This female teddy", a1);
        customerDogRepository.save(dog);

        // storing dogs in a list
        List<Dog> dogList = customerDogRepository.findAll();

        assertThat(customerDogRepository.getBreed()).isNotNull();
    }

    @DisplayName("Test get gender")
    @Test
    void getGender() {
        Address a1 = new Address();
        a1.setStreetName("24th Ave NW");a1.setHouseNum(2345);a1.setCity("Seattle");a1.setState("WA");a1.setZipCode(23000);

        Dog dog = new Dog("Poodle", "Teddy", 10, "female", "Teddypoddle@hotmail.com", "https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg", "This female teddy", a1);
        customerDogRepository.save(dog);

        // storing dogs in a list
        List<Dog> dogList = customerDogRepository.findAll();

        assertThat(customerDogRepository.getGender()).isNotNull();
    }

}