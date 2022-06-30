package com.example.petdate.service;


import com.example.petdate.data.AddressRepository;
import com.example.petdate.data.AdminDogRepository;
import com.example.petdate.model.Address;
import com.example.petdate.model.Dog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import javax.persistence.EntityManager;




//@RunWith(SpringRunner.class)


@SpringBootTest

public class AdminDogServiceTest {

//    @Autowired
//    TestEntityManager entityManager;
    @Autowired
    private AdminDogRepository adminDogRepository;

    @Autowired
    private AddressRepository addressRepository;

    // test save dog
    @Test
    @Order(2)
    @DisplayName("Test save dog")
    public void saveDog() {
        Address a1 = new Address();
        a1.setStreetName("24th Ave NW");a1.setHouseNum(2345);a1.setCity("Seattle");a1.setState("WA");a1.setZipCode(23000);

        Dog dog = new Dog("Poodle", "Teddy", 10, "female", "Teddypoddle@hotmail.com", "https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg", "This female teddy", a1);
        adminDogRepository.save(dog);
        assertThat(dog.getId()).isNotNull();
    }

    // test get dog
    @Order(3)
    @DisplayName("Test get Dog")
    @Test
    public void getDogTest(){
        Dog dog = adminDogRepository.findById(1).get();
        assertThat(dog.getId()).isEqualTo(1);
    }

    // test get dog
    @Order(4)
    @DisplayName("Test deletion Dog")
    @Test
    public void deleteDogTest(){
        Address a1 = new Address();
        a1.setStreetName("24th Ave NW");a1.setHouseNum(2345);a1.setCity("Seattle");a1.setState("WA");a1.setZipCode(23000);
        adminDogRepository.save(new Dog("German Shepherd","Max",11,"male","Shephered@gmail.com","https://cdn1.photostockeditor.com/t/0401/animal-two-short-coated-brown-and-black-dogs-playing-dog-dog-image.jpg","This is my best dog",a1));
        // delete(dog) is null fails
        adminDogRepository.deleteAll();

        assertThat(adminDogRepository.findAll()).isNull();
    }
}
