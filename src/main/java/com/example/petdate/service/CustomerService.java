package com.example.petdate.service;

import com.example.petdate.model.Dog;
import com.example.petdate.data.CustomerDogRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
public class CustomerService {

    CustomerDogRepository customerDogRepository;
    @Autowired
    public CustomerService(CustomerDogRepository customerDogRepository){
        this.customerDogRepository = customerDogRepository;
    }

    // get all dogs
    public List<Dog> findAll(){
        return customerDogRepository.findAll();
    }

    // getDog by id
    public Dog findById(Integer id) throws NoSuchElementException {
        return customerDogRepository.findById(id).orElseThrow();
    }

    // getdog by breed
//    public Dog findDogByBreed(String breed){
//        return customerDogRepository.findByBreed(breed).orElseThrow();
//    }

    // Querries
    // get dogs by selected breed
    public List<Object> findBreed()
    {
        return customerDogRepository.getBreed();
    }

    // get dogs by selected breed
    public List<Object> findGender()
    {
        return customerDogRepository.getGender();
    }

    // get dog city
    public List<Object> findCity()
    {
        return customerDogRepository.getCity();
    }
}
