package com.example.petdate.controller;

import com.example.petdate.model.Dog;
import com.example.petdate.service.AdminDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
// standards of url endpoint we usually use when we develop rest API
@RequestMapping("/api/admin")
public class AdminDogController {


    AdminDogService adminDogService;

    @Autowired
    public AdminDogController(AdminDogService adminDogService) {
        this.adminDogService = adminDogService;
    }

    //get all dogs that will return a list of dogs using findall
    // we specify URL that we want the return list, we define endpoint that method is mapped to
    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return adminDogService.findAll();
    }

    // create dog
    @PostMapping("/dogs")
    public Dog createDog(@RequestBody Dog dog) {
        return adminDogService.saveDog(dog);
    }

    // find dog by id
    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable int id) {
        Dog dog = adminDogService.findById(id);
        return ResponseEntity.ok(dog);
    }

    // update dog
    @PutMapping("/dogs/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable int id, @RequestBody Dog DogDetails) {
        // lets get dogs from database
        Dog dog = adminDogService.findById(id);  // add exception here if id does not exist
        dog.setBreed(DogDetails.getBreed());
        dog.setName(DogDetails.getName());
        dog.setAge(DogDetails.getAge());
        dog.setGender(DogDetails.getGender());
        dog.setEmail(DogDetails.getEmail());
        dog.setImageurl(DogDetails.getImageurl());
        dog.setDescription(dog.getDescription());
        // after we get them we save to database by calling save Dog
        Dog updatedDog = adminDogService.saveDog(dog);
        return ResponseEntity.ok(updatedDog);
    }

    // delete dog - response entity as a return type
    @DeleteMapping("/dogs/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDogById(@PathVariable int id) {
        // first get employee by id
        Dog dog = adminDogService.findById(id);  // add exception here if id do not exist
        adminDogService.deleteDog(dog);
        // notify admin that delete went through successfully
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
