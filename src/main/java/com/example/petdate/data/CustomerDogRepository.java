package com.example.petdate.data;

import com.example.petdate.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDogRepository extends JpaRepository<Dog,Integer> {

    // find dog by breed
//    Optional<Dog> findByBreed(String name);

    // Querries, using native, dog is name of table in database not the class
    // I will get a list back of dogs by breed name
    @Query(nativeQuery = true,value = "SELECT distinct d.breed from dog d")
    public List<Object> getBreed();

    // I will get a list of dogs back based on the gender I want
    @Query(nativeQuery= true, value="SELECT distinct d.gender from dog d")
    public List<Object> getGender();

    // get dog city, I will join table dog and address to get dog city
    @Query(nativeQuery= true, value="SELECT  a.city from address a INNER JOIN dog d ON d.id = a.address_id")
    public List<Object> getCity();


    // call the stored procedure filtering method with its parameters
    @Query(value = "CALL uspGetFilteredDogs(:gender,:breed);", nativeQuery = true)
    public List<Dog> getFilteredDogs(@Param("gender") String  gender, @Param("breed") String breed);

}
