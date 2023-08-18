package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(UserRepository userRepository, FacilityRepository facilityRepository, CalendarRepository calendarRepository){
//		return args -> {
//			Calendar calendar1= new Calendar();
//			String email1="abc@gmail.com";
//			User user= new User(
//					email1, "123456","Vishnu","Student","https://www.google.com/url?sa=i&url=https%3A%2F%2Fnepalyogahome.com%2Flord-vishnu-the-protector-of-universe%2F&psig=AOvVaw2ibsaoUwsSaC8opZMAntus&ust=1682756983094000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNC5n7SUzP4CFQAAAAAdAAAAABAD",calendar1.calendarId
//			);
//			Calendar calendar2= new Calendar();
//			String name1="Auditorium";
//			Facility facility= new Facility(
//					name1,"Auditorium", "https://www.google.com/imgres?imgurl=https%3A%2F%2Fthearchitectsdiary.com%2Fwp-content%2Fuploads%2F2020%2F01%2FRahul-Malhotra-Audi-The-Architects-Diary-FI.jpg&tbnid=CBdfA7HNCb_uZM&vet=12ahUKEwjwgZ2slcz-AhWNyHMBHZIYApsQMygDegUIARC7AQ..i&imgrefurl=https%3A%2F%2Fthearchitectsdiary.com%2Fauditorium-design-for-bits-pilani-at-hyderabad-rmm-designs%2F&docid=kwokBR0xSJTjqM&w=1277&h=826&q=bits%20hyderabad%20auditorium&client=safari&ved=2ahUKEwjwgZ2slcz-AhWNyHMBHZIYApsQMygDegUIARC7AQ",calendar2.calendarId
//			);
//			userRepository.findUserByEmail(email1)
//					.ifPresentOrElse(u->{
//						System.out.println(u+" Already exists");
//					},()->{
//						System.out.println("Inserting user: "+ user);
//						calendarRepository.insert(calendar1);
//						userRepository.insert(user);
//					});
//			facilityRepository.findFacilityByName(name1)
//					.ifPresentOrElse(f->{
//						System.out.println(f+" Already exists");
//					},()->{
//						System.out.println("Inserting facility: "+ facility);
//						calendarRepository.insert(calendar2);
//						facilityRepository.insert(facility);
//					});
//		};
//	}

}
