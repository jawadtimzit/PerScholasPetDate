package com.example.petdate.service;

import com.example.petdate.data.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceTest {

    // test that the injected compoenent in address service is not null
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    public AddressServiceTest(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    // test that injected addressRepository is not null
    @Test
    void injectedComponentIsNotNull() {
        assertThat(addressRepository).isNotNull();

    }

}