package com.example.petdate.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "dog")
@Entity

// create Dog Entity model
public class Dog {

    // data fields, attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk auto
    @Column(name = "id")
    int id;

    @NonNull
    @Column(length = 50, nullable = false, name ="breed")
    String breed;

    @NonNull
    @Column(length = 50, nullable = false, name="name")
    String name;

    @NonNull
    @Column(length = 2, nullable =false, name = "age")
    int age;

    @NonNull
    @Size(min=4, message = "gender should have at least 4 characters")
    @Column(length = 50, nullable = false, name="gender")
    String gender;

    @NonNull
    // email should be a valid email format
    @Email
    @Column(length = 50, nullable = false, name="email")
    String email;

    @NonNull
    @Column(length =150, nullable = false, name="imageurl")
    String imageurl;

    @NonNull
    @Column(length = 150, nullable = false, name="description")
    String description;
    @ToString.Exclude
    @NonNull
    // This is the owning side
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "address_fk", referencedColumnName = "addressid")
    // create reference of address entity
    //relationship among Address and Dog or model object wto return back Json
    @JsonBackReference
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && age == dog.age && breed.equals(dog.breed) && name.equals(dog.name) && gender.equals(dog.gender) && description.equals(dog.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, breed, name, age, gender, description);
    }

}
