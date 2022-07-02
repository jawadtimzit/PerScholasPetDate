package com.example.petdate;

import com.example.petdate.model.*;
import com.example.petdate.data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PerScholasPetDateApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure
			(SpringApplicationBuilder application){
		return application.sources(PerScholasPetDateApplication.class);
	}
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
			a1.setStreetName("24th Ave NW"); a1.setHouseNum(2345); a1.setCity("Seattle"); a1.setState("WA"); a1.setZipCode(98108);
			Address a2 = new Address();
			a2.setStreetName("12th Ave NW"); a2.setHouseNum(324); a2.setCity("Lynnwood"); a2.setState("WA"); a2.setZipCode(90002);
			Address a3 = new Address();
			a3.setStreetName("10th Ave SW"); a3.setHouseNum(12); a3.setCity("Bellevue"); a3.setState("WA"); a3.setZipCode(98004);
			Address a4 = new Address();
			a4.setStreetName("2805 east Madison"); a4.setHouseNum(234); a4.setCity("Seattle"); a4.setState("WA"); a4.setZipCode(98117);
//			Address a5 = new Address();
//			a5.setStreetName("1123 east Bellevue"); a5.setHouseNum(1324); a5.setCity("Lynnwood"); a5.setState("WA"); a5.setZipCode(98003);
//			Address a6 = new Address();
//			a6.setStreetName("223 Harison st"); a6.setHouseNum(5678); a6.setCity("Bellevue"); a6.setState("WA"); a6.setZipCode(98005);
//			Address a7 = new Address();
//			a7.setStreetName("2889 east Jon"); a7.setHouseNum(234); a7.setCity("Seattle"); a7.setState("WA"); a7.setZipCode(98107);
//			Address a8 = new Address();
//			a8.setStreetName("2567 east Jeffery st"); a8.setHouseNum(4567); a8.setCity("Lynnwood"); a8.setState("WA"); a8.setZipCode(98005);
//			Address a9 = new Address();
//			a9.setStreetName("2805 east Jeffery st"); a9.setHouseNum(234); a9.setCity("Bellevue"); a9.setState("WA"); a9.setZipCode(98006);
//			Address a10 = new Address();
//			a10.setStreetName("2805 Denny way"); a10.setHouseNum(3456); a10.setCity("Seattle"); a10.setState("WA"); a10.setZipCode(98119);
//			Address a11 = new Address();
//			a11.setStreetName("1234 Melrose st"); a11.setHouseNum(6789); a11.setCity("Lynnwood"); a11.setState("WA"); a11.setZipCode(98004);
//			Address a12 = new Address();
//			a12.setStreetName("2805 east Madison"); a12.setHouseNum(234); a12.setCity("Bellevue"); a12.setState("WA"); a12.setZipCode(98008);
//			Address a13 = new Address();
//			a13.setStreetName("1234 23th AVE"); a13.setHouseNum(7689); a13.setCity("Seattle"); a13.setState("WA"); a13.setZipCode(98107);
//			Address a14 = new Address();
//			a14.setStreetName("1234 23th AVE"); a14.setHouseNum(4567); a14.setCity("Lynnwood"); a14.setState("WA"); a14.setZipCode(98005);
//			Address a15 = new Address();
//			a15.setStreetName("1234 23th AVE"); a15.setHouseNum(234); a15.setCity("Bellevue"); a15.setState("WA"); a15.setZipCode(98010);
//			Address a16 = new Address();
//			a16.setStreetName("15th Ave s"); a16.setHouseNum(3456); a16.setCity("Seattle"); a16.setState("WA"); a16.setZipCode(98102);
//			Address a17 = new Address();
//			a17.setStreetName("5th Ave s"); a17.setHouseNum(9809); a17.setCity("Lynnwood"); a17.setState("WA"); a17.setZipCode(98006);
//			Address a18 = new Address();
//			a18.setStreetName("Marginal way s"); a18.setHouseNum(3456); a18.setCity("Bellevue"); a18.setState("WA"); a18.setZipCode(98012);
//			Address a19 = new Address();
//			a19.setStreetName("Marginal way s"); a19.setHouseNum(6793); a19.setCity("Seattle"); a19.setState("WA"); a19.setZipCode(98107);
//			Address a20 = new Address();
//			a20.setStreetName("Marginal Way E"); a20.setHouseNum(7812); a20.setCity("Lynnwood"); a20.setState("WA"); a20.setZipCode(98004);
//			Address a21 = new Address();
//			a21.setStreetName("Harisson st"); a21.setHouseNum(4567); a21.setCity("Bellevue"); a21.setState("WA"); a21.setZipCode(98105);
//			Address a22 = new Address();
//			a22.setStreetName("Jhon st SW"); a22.setHouseNum(321); a22.setCity("Seattle"); a22.setState("WA"); a22.setZipCode(98119);
//			Address a23 = new Address();
//			a23.setStreetName("Republican st SW"); a23.setHouseNum(619); a23.setCity("Lynnwood"); a23.setState("WA"); a23.setZipCode(98003);
//			Address a24 = new Address();
//			a24.setStreetName("Jeffery St S"); a24.setHouseNum(8721); a24.setCity("Bellevue"); a24.setState("WA"); a24.setZipCode(98004);
//			Address a25 = new Address();
//			a25.setStreetName("212 AVE SW"); a25.setHouseNum(672); a25.setCity("Seattle"); a25.setState("WA"); a25.setZipCode(98107);
//			Address a26 = new Address();
//			a26.setStreetName("223 AVE S"); a26.setHouseNum(987); a26.setCity("Lynnwood"); a26.setState("WA"); a26.setZipCode(98105);
//			Address a27 = new Address();
//			a27.setStreetName("65 S Harisson"); a27.setHouseNum(671); a27.setCity("Bellevue"); a27.setState("WA"); a27.setZipCode(98106);
//			Address a28 = new Address();
//			a28.setStreetName("51 ST SW"); a28.setHouseNum(9087); a28.setCity("Seattle"); a28.setState("WA"); a28.setZipCode(98107);

			// save test dog data to database--------for filetering
			adminDogRepository.save(new Dog("pitbull","Max",11,"male","Shephered@gmail.com","https://cdn1.photostockeditor.com/t/0401/animal-two-short-coated-brown-and-black-dogs-playing-dog-dog-image.jpg","This is my best dog",a1));
			adminDogRepository.save(new Dog("Bulldog","Oscar",15,"male","bulldogoscar@gmail.com","https://s28489.pcdn.co/wp-content/uploads/2021/03/IMG_5084.jpg.optimal.jpg","This is Oscar",a2));
			adminDogRepository.save(new Dog("Poodle","Teddy",10,"female","Teddypoddle@hotmail.com","https://wtop.com/wp-content/uploads/2019/01/2920895-1880x1254.jpg","This female teddy",a3));
			// beagle
			adminDogRepository.save(new Dog("beagle","Ace",10,"male","Ace10@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/beagle4.jpg","Describe dog...",a4));
//			adminDogRepository.save(new Dog("beagle","Bailey",11,"male","Bailey@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/beagle5.jpg","Describe dog...",a5));
//			adminDogRepository.save(new Dog("beagle","Charlie",9,"male","Charlie@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/beagle1.jpg","Describe dog...",a6));
//			adminDogRepository.save(new Dog("beagle","Dexter",8,"female","Dexter@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/beagle2.jpg","Describe dog...",a7));
//			adminDogRepository.save(new Dog("beagle","Daisy",11,"female","Daisy@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/beagle3.jpg","Describe dog...",a8));
//			// husky
//			adminDogRepository.save(new Dog("husky","Duke",1,"male","Duke@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/husky1.jpg","Describe dog...",a9));
//			adminDogRepository.save(new Dog("husky","Max",8,"male","Max@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/husky5.jpg","Describe dog...",a10));
//			adminDogRepository.save(new Dog("husky","Bailey",7,"female","Bailey@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/husky4.jpg","Describe dog...",a11));
//			adminDogRepository.save(new Dog("husky","Chloe",6,"female","Chloe@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/husky3.jpg","Describe dog...",a12));
//			adminDogRepository.save(new Dog("husky","Luna",2,"female","Luna@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/husky2.jpg","Describe dog...",a13));
//			//labarador
//			adminDogRepository.save(new Dog("labrador","Cooper",11,"male","Cooper@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/labarador4.jpg","Describe dog...",a14));
//			adminDogRepository.save(new Dog("labrador","Milo",10,"male","Milo@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/labarador1.jpeg","Describe dog...",a15));
//			adminDogRepository.save(new Dog("labrador","Oliver",1,"male","Oliver@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/labarador2.jpg","Describe dog...",a16));
//			adminDogRepository.save(new Dog("labrador","Lola",7,"female","Lola@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/labarador3.jpg","Describe dog...",a17));
//			adminDogRepository.save(new Dog("labrador","Angel",8,"female","Angel@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/labarador5.jpg","Describe dog...",a18));
//			//malamute
//			adminDogRepository.save(new Dog("malamute","Ginger",7,"female","Ginger@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/malamute5.jpg","Describe dog...",a19));
//			adminDogRepository.save(new Dog("malamute","Lady",10,"female","Lady@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/malamute4.jpg","Describe dog...",a20));
//			adminDogRepository.save(new Dog("malamute","Stella",8,"female","Stella@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/malamute3.jpg","Describe dog...",a21));
//			adminDogRepository.save(new Dog("malamute","Buddy",5,"male","Buddy@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/malamute2.jpg","Describe dog...",a22));
//			adminDogRepository.save(new Dog("malamute","Rocky",4,"male","Rockey@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/malamute1.png","This female teddy",a23));
//			//Shephered
//			adminDogRepository.save(new Dog("Shepherd","Dingo",1,"male","Dingo@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/shephered1.jpg","Describe dog...",a24));
//			adminDogRepository.save(new Dog("Shepherd","Rocket",1,"male","Rocket@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/shephered1.jpg","Describe dog...",a25));
//			adminDogRepository.save(new Dog("Shepherd","Blaze",1,"male","Blaze@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/shephered3.jpg","Describe dog...",a26));
//			adminDogRepository.save(new Dog("Shepherd","Charlie",10,"female","Charlie@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/shephered5.jpeg","Describe dog...",a27));
//			adminDogRepository.save(new Dog("Shepherd","Ruby",7,"female","Ruby@hotmail.com","https://jawadpetdate.s3.us-west-2.amazonaws.com/shephered4.jpg","Describe dog...",a28));


			// save some toy data to database
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy1-rope.jpg","Rope",15));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy10-yellowshew.jpg","Yellow Shew",17));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy2-spike.jpg","Blue Spike",10));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy3-balls.jpg","Six Balls",13));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy4-balls2.jpg","Strike Balls",12));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy5-balls2.jpg","Spike & Balls",21));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy6-chew1.jpeg","Blue Shew",22));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy7-puppies1.jpg","Puppy Toy",11));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy8-kong.jpg","Red Kong",13));
			toyRepository.save(new Toy("https://jawadpetdate.s3.us-west-2.amazonaws.com/toy9-whiteball.jpg","Spike & White Ball",23));

			// save user admin with hash values in database
			urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));


			// save some customer data to database
			adminCustomerRepository.save(new Customer("jackedward@gmail.com", "password", "jack", "edward", "address1"));
			adminCustomerRepository.save(new Customer("michealtest@gmail.com", "password", "micheal", "test", "address2"));
			adminCustomerRepository.save(new Customer("jackiesmith@gmail.com", "password", "jackie", "smith", "address3"));

			// save some addresses in database


		};
	}
}
