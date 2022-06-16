package com.example.petdate.controller;

import com.example.petdate.model.Dog;
import com.example.petdate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
// standards of url endpoint we usually use when we develop rest API
@RequestMapping("/api/customer")
public class CustomerController {

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

}
