package com.example.petdate.service;

import com.example.petdate.model.Dog;
import com.example.petdate.data.AdminDogRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
public class AdminDogService {

    // inject dog repo by spring container
    // the dog service repo object
    AdminDogRepository adminDogRepository;
    @Autowired
    public AdminDogService(AdminDogRepository dogRepository){
        this.adminDogRepository = dogRepository;
    }

    // get all dogs
    public List<Dog> findAll(){
        return adminDogRepository.findAll();
    }

    // create dog will take in dog of type Dog
    public Dog saveDog(Dog dog){
        return adminDogRepository.save(dog);
    }

    // find dog by breed
    public Dog findById(Integer id) throws NoSuchElementException{
        return adminDogRepository.findById(id).orElseThrow();
    }
    // update dog
    public void updateDog(Dog dog){
        // I will bring method controller --- implementation
    }
    // delete method to delete dog items
    public void deleteDog(Dog dog){
        adminDogRepository.delete(dog);
    }
}
