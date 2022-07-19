package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<Role>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<Role>()));
			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<Role>()));
			userService.saveUser(new User(null, "Dusan Vlahovic", "vlahovic", "1234", new ArrayList<Role>()));

			userService.addRoleToUser("vlahovic", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("vlahovic", "ROLE_ADMIN");
			userService.addRoleToUser("jim", "ROLE_USER");
			userService.addRoleToUser("will", "ROLE_MANAGER");

		};
	}
}
