package com.example.petdate.controller;

import com.example.petdate.data.CustomerDogRepository;
import com.example.petdate.model.Dog;
import com.example.petdate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
// standards of url endpoint we usually use when we develop rest API
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerDogRepository customerDogRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    //get all dogs that will return a list of dogs using findall
    // we specify URL that we want the return list, we define endpoint that method is mapped to
    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return customerService.findAll();
    }

    // get dog by id
    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable int id) {
        Dog dog = customerService.findById(id);
        return ResponseEntity.ok(dog);
    }

    // Querries
    // find dog by breed
    // return dogs with breed name
    @GetMapping("/getDogBreed")
    public List<Object> getDogBreed()
    {
        return customerService.findBreed();
    }

    // return dogs by gender
    @GetMapping("/getDogGender")
    public List<Object> getDogGender()
    {
        return customerService.findGender();
    }

    // return dog city
    @GetMapping("/getDogCity")
    public List<Object> getDogCity()
    {
        return customerService.findCity();
    }

    // get filtered dogs --- service methode
    @GetMapping("/getFilteredDogs")
    // get filtered dogs
    public List<Dog> getFilteredDogs(@RequestParam String gender, @RequestParam String breed){
        return customerDogRepository.getFilteredDogs(gender, breed);
    }
}
