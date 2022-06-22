package com.example.petdate;

import com.example.petdate.controller.AdminDogController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PerScholasPetDateApplicationTests {
	@Autowired
	private AdminDogController dogController;

	@Test
	void contextLoads() {
		// test checks that the instance of the controller was created and
		// injected successfully
		assertThat(dogController).isNotNull();
	}

}
