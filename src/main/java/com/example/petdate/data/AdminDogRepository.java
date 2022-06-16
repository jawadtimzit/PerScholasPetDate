package com.example.petdate.data;

import com.example.petdate.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// lets extend Jpa repository that has all methods like save, findall, find byid etc
// those methods already implemented in Jpa Repo
// pass Dog and type of PK
@Repository
public interface AdminDogRepository extends JpaRepository<Dog,Integer> {

}
