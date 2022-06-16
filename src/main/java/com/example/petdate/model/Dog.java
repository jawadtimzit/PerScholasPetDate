package com.example.petdate.model;


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
    @Column(length = 20, nullable = false, name="gender")
    String gender;

    @NonNull
    @Column(length = 50, nullable = false, name="email")
    String email;

    @NonNull
    @Column(length =150, nullable = false, name="imageurl")
    String imageurl;

    @NonNull
    @Column(length = 150, nullable = false, name="description")
    String description;

    // I will exclude tostring to avoid infinite loop
    // between dog, admin and also dog with address
    //  @ToString.Exclude

    // override equal and hashchode
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
