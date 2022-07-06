package com.example.petdate.service;


import com.example.petdate.data.AddressRepository;
import com.example.petdate.data.AdminDogRepository;
import com.example.petdate.model.Address;
import com.example.petdate.model.Dog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest

public class AdminDogServiceTest {

    @Autowired
    private AdminDogRepository adminDogRepository;

    @Autowired
    private AddressRepository addressRepository;

    // after each test delete everyone
    @AfterEach
    public void tearDown(){
        addressRepository.deleteAll();
    }

    // test save dog
    @Test
    @DisplayName("Add dog object")
    // new dog addition to database and we check that dog id is not null and does exist
    public void addDog() {
        Address a1 = new Address();
        a1.setStreetName("24th Ave NW");a1.setHouseNum(2345);a1.setCity("Seattle");a1.setState("WA");a1.setZipCode(23000);

        Dog dog = new Dog("Poodle", "Teddy", 10, "female", "Teddypoddle@hotmail.com", "https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg", "This female teddy", a1);
        adminDogRepository.save(dog);
        // check that Id is not null
        assertThat(dog.getId()).isNotNull();

    }

    // test get dog
    @DisplayName("Test get Dog")
    @Test
    public void getDogTest(){
        Dog dog = adminDogRepository.findById(1).get();
        assertThat(dog.getId()).isEqualTo(1);
    }


}
