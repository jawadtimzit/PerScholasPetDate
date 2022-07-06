package com.example.petdate.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "payment")
@Entity

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk auto
    @Column(name = "paymentid")
    int addressId;

    @NonNull
    @Column(length = 50, nullable = false, name ="paydate")
    Date payDate;

    @NonNull
    @Column(length = 20, nullable = false, name ="amount")
    double amount;



}
