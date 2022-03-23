package com.projectmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectmanagement.model.service.UserService;

@SpringBootApplication
public class ProjectManagementApplication implements CommandLineRunner {
	
	/**Autowiring Reference of UserService to perform operations for various mappings */
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// adding user into database

		// userService.AddUser(new User("joe", "pqr"));
		// userService.AddUser(new User("pawan", "pawan"));
	}

}
