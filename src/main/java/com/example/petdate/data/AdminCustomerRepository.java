package com.example.petdate.data;

import com.example.petdate.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminCustomerRepository extends JpaRepository<Customer, Integer> {
}
