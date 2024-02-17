package com.jkm.rentez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentezApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentezApplication.class, args);
		SayHello();
	}

	public static void SayHello(){
		System.out.println("hejejejjejej");
	}

}
