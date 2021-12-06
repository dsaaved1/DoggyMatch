package com.iastate._rk_1;

import com.iastate._rk_1.backend.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iastate._rk_1.backend.entity.User;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class Main {

	
  public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
