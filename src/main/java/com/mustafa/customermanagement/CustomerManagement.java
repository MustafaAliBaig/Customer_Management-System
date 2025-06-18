package com.mustafa.customermanagement;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CustomerManagement {

	@Autowired
	private Environment environment;
	public static void main(String[] args) {
		SpringApplication.run(CustomerManagement.class, args);
	}

	@PostConstruct
	public void printActiveProfiles(){
		System.out.println(" Active Spring Profiles:" + Arrays.toString(environment.getActiveProfiles()));
	}
}
