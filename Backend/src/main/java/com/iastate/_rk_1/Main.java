package com.iastate._rk_1;

import com.iastate._rk_1.backend.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iastate._rk_1.backend.entity.User;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initUser(UserRepository userRepository) {
		return args -> {
			User user1 = new User("Peyton", "Arbuckle", "peyt@iastate.edu", "password");
			userRepository.save(user1);
		};
	}
}
