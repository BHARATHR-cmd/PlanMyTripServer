package com.Mindtree.PlanMyTripServer;

import com.Mindtree.PlanMyTripServer.Model.TypeEntity;
import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import com.Mindtree.PlanMyTripServer.Service.TypeService;
import com.Mindtree.PlanMyTripServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class PlanMyTripServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PlanMyTripServerApplication.class, args);
	}
	@Override
	public void run(String ... args) throws Exception{
//		UserEntity userEntity = new UserEntity();
//		userEntity.setName("Bharath");
//		userEntity.setEmailId("bharathgowda926@gmail.com");
//		userEntity.setProfilepic("default.jpeg");
//		userEntity.setPassword(bCryptPasswordEncoder.encode("12345678"));
//		userEntity.setPhone("123456789");
//		userEntity.setRole("ADMIN");
//		this.userService.createUser(userEntity);
//
//		TypeEntity typeEntity1 = new TypeEntity();
//		typeEntity1.setType("Economy Class");
//		typeEntity1.setTprice(15000);
//		typeService.createType(typeEntity1);
//
//		TypeEntity typeEntity2 = new TypeEntity();
//		typeEntity2.setType("First Class");
//		typeEntity2.setTprice(25000);
//		typeService.createType(typeEntity2);
//
//
//		TypeEntity typeEntity3 = new TypeEntity();
//		typeEntity3.setType("Premium Class");
//		typeEntity3.setTprice(40000);
//		typeService.createType(typeEntity3);
//
//
//		UserEntity userEntity = new UserEntity();
//		userEntity.setName("Bharath");
//		userEntity.setEmailId("bgggowda@gmail.com");
//		userEntity.setProfilepic("default.jpeg");
//		userEntity.setPassword(bCryptPasswordEncoder.encode("12345678"));
//		userEntity.setPhone("123456789");
//		userEntity.setRole("ADMIN");
//		this.userService.createUser(userEntity);




	}
}



