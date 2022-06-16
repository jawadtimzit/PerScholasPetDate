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
@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk auto
    @Column(name = "customerid")
    int id;

    @NonNull
    @Column(length = 50, nullable = false, name ="email")
    String email;

    @NonNull
    @Column(length = 50, nullable = false, name ="custpassword")
    String custPassword;

    @NonNull
    @Column(length = 50, nullable = false, name ="firstname")
    String firstName;

    @NonNull
    @Column(length = 50, nullable = false, name ="lastname")
    String lastName;
    @NonNull

    // check this if needs to be here or coming as fk from address table
    @Column(length = 50, nullable = false, name ="address")
    String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && email.equals(customer.email) && custPassword.equals(customer.custPassword) && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && address.equals(customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, custPassword, firstName, lastName, address);
    }
}
