package com.example.petdate.data;

import com.example.petdate.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDogRepository extends JpaRepository<Dog,Integer> {
}
