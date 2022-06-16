package com.example.petdate.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
// standards of url endpoint we usually use when we develop rest API
@RequestMapping("/api/customer")
public class ToyCustomerController {

}
