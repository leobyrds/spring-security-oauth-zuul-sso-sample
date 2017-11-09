package com.hna.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@EnableResourceServer
public class ResourceApplication {

	@RequestMapping("/")
	public String home(Principal user) {
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
}
