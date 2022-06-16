package com.example.petdate.data;

import com.example.petdate.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, Integer> {

}
