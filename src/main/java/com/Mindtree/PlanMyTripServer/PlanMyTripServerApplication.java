package com.Mindtree.PlanMyTripServer;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
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
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PlanMyTripServerApplication.class, args);
	}
	@Override
	public void run(String ... args) throws Exception{
		UserEntity userEntity = new UserEntity();
		userEntity.setName("Bharath");
		userEntity.setEmailId("bharathgowda926@gmail.com");
		userEntity.setProfilepic("deg");
		userEntity.setPassword(bCryptPasswordEncoder.encode("abc"));
		userEntity.setPhone("123456789");
		userEntity.setRole("ADMIN");


	this.userService.createUser(userEntity);




	}
}



