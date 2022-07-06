package com.example.petdate.controller;


import com.example.petdate.data.ToyRepository;
import com.example.petdate.model.Dog;
import com.example.petdate.model.Toy;
import com.example.petdate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
// standards of url endpoint we usually use when we develop rest API
@RequestMapping("/api/customer")
public class ToyCustomerController {

    // invoke the customerService object to call customerService methods on controller endpoints
    @Autowired
    CustomerService customerService;
    @Autowired
    public ToyCustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    // endpoints to get all toys
    @GetMapping("/toys")
    public List<Toy> getAllToys() {
        return customerService.findAllToys();
    }

    // get toy by Id
    @GetMapping("/toys/{id}")
    public ResponseEntity<Toy> getToyById(@PathVariable int id) {
        Toy toy = customerService.findToyById(id);
        return ResponseEntity.ok(toy);
    }
}
