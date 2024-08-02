package com.personalfinance;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;




@SpringBootApplication
public class PersonalfinanceprojectApplication {
	@PostConstruct
	public void calculaNumb() {
		System.out.println("hi there im using whats app");
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonalfinanceprojectApplication.class, args);
	}

}
//1280335c-bb96-4efc-80a5-dbfcc158ff23