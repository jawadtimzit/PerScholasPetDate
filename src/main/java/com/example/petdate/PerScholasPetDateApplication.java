package com.example.petdate;

import com.example.petdate.model.*;
import com.example.petdate.data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PerScholasPetDateApplication {
	// inject the dogRepository here to be able to save a new dog object to database
	@Autowired
	private AdminDogRepository adminDogRepository;
	@Autowired
	private UserRepository urepository;
	@Autowired
	private ToyRepository toyRepository;
	@Autowired
	private AdminCustomerRepository adminCustomerRepository;
	@Autowired
	private AddressRepository addressRepository;



	public static void main(String[] args) {
		SpringApplication.run(PerScholasPetDateApplication.class, args);

	}
	// lets use commadlineRunner interface that will allow to excute additional code
	//before the application has fully started
	@Bean
	CommandLineRunner runner(){
		return args -> {

			// create address objects
			Address a1 = new Address();
			a1.setStreetName("24th Ave NW"); a1.setHouseNum(2345); a1.setCity("Seattle"); a1.setState("WA"); a1.setZipCode(23000);
			Address a2 = new Address();
			a2.setStreetName("12th Ave NW"); a2.setHouseNum(324); a2.setCity("Miami"); a2.setState("FL"); a2.setZipCode(33769);
			Address a3 = new Address();
			a3.setStreetName("10th Ave SW"); a3.setHouseNum(12); a3.setCity("San Diego"); a3.setState("CA"); a3.setZipCode(22400);

			// save test dog data to database
			adminDogRepository.save(new Dog("German Shepherd","Max",11,"male","Shephered@gmail.com","https://cdn1.photostockeditor.com/t/0401/animal-two-short-coated-brown-and-black-dogs-playing-dog-dog-image.jpg","This is my best dog",a1));
			adminDogRepository.save(new Dog("Bulldog","Oscar",15,"male","bulldogoscar@gmail.com","https://s28489.pcdn.co/wp-content/uploads/2021/03/IMG_5084.jpg.optimal.jpg","This is Oscar",a2));
			adminDogRepository.save(new Dog("Poodle","Teddy",10,"female","Teddypoddle@hotmail.com","https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg","This female teddy",a3));
//			// save user admin with hash values in database
			urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
			// save some toy data to database
			toyRepository.save(new Toy("https://www.gstatic.com/webp/gallery/1.jpg","dogy ball",15));
			toyRepository.save(new Toy("https://www.gstatic.com/webp/gallery/1.jpg","dogy baskett",25));
			toyRepository.save(new Toy("https://www.gstatic.com/webp/gallery/1.jpg","dog goddie bone",10));
			// save some customer data to database
			adminCustomerRepository.save(new Customer("jackedward@gmail.com", "password", "jack", "edward", "address1"));
			adminCustomerRepository.save(new Customer("michealtest@gmail.com", "password", "micheal", "test", "address2"));
			adminCustomerRepository.save(new Customer("jackiesmith@gmail.com", "password", "jackie", "smith", "address3"));

			// save some addresses in database


		};
	}
}
