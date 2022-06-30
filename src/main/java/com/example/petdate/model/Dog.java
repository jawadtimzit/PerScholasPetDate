package com.example.petdate.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
    @Column(length = 50, nullable = false, name="gender")
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

    //--------------------//
//    @ToString.Exclude
//    // biderectional two sides / owning and referencing side
//    // owning side of aasociation defins mapping
//    // reference side links to that mapping
    @ToString.Exclude
    @NonNull
    // This is the owning side
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "address_fk", referencedColumnName = "addressid")
    // create reference of address entity
    //relationship among Address and Dog or model object wto return back Json
    @JsonBackReference
    private Address address;




//------------------------------------------------------//

//    @ToString.Exclude
//    @OneToMany( mappedBy = "dog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    Set<Address> addresse = new LinkedHashSet<>();

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
