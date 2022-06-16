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
}
