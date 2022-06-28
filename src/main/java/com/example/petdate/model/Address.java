package com.example.petdate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk auto
    @Column(name = "addressid")
    int addressId;

    @NonNull
    @Column(length = 50, nullable = false, name ="streetname")
    String streetName;

    @NonNull
    @Column(length = 10, nullable = false, name ="housenum")
    int houseNum;

    @NonNull
    @Column(length = 50, nullable = false, name ="city")
    String city;

    @NonNull
    @Column(length = 2, nullable = false, name ="state")
    String state;

    @NonNull
    @Column(length = 20, nullable = false, name ="zipcode")
    int zipCode;

    //--------------------------------//
    @ToString.Exclude
    @NonNull
    @OneToOne( mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    ////relationship among Address and Dog or model object wto return back Json
    @JsonBackReference
    // I have created a reference for dog entity
    private  Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
    //------------------------------------------------//
//    @NonNull
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinColumn(name = "dog_id")
//    Dog dog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId && houseNum == address.houseNum && zipCode == address.zipCode && streetName.equals(address.streetName) && city.equals(address.city) && state.equals(address.state) && dog.equals(address.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, streetName, houseNum, city, state, zipCode, dog);
    }
}
