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
@Table(name = "toy")
@Entity
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk auto
    @Column(name = "toyid")
    int id;
    @NonNull
    @Column(length = 150, nullable = false, name ="imageurl")
    String imageurl;
    @NonNull
    @Column(length = 50, nullable = false, name ="toyname")
    String toyname;
    @NonNull
    @Column(length = 50, nullable = false, name ="price")
    double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id && Double.compare(toy.price, price) == 0 && imageurl.equals(toy.imageurl) && toyname.equals(toy.toyname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageurl, toyname, price);
    }
}
