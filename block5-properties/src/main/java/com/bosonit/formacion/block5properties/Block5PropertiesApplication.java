package com.bosonit.formacion.block5properties;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication {

	@Value("${greeting}")
	private String greeting;
	@Value("${my.number}")
	private int number;
	@Value("${new.property:new.property no tiene valor}")
	private String nueva;

	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

	@PostConstruct
	private void postConstruct(){
		System.out.println("Valor de greeting: " + greeting);
		System.out.println("Valor de my.number: " + number);
		System.out.println("Valor de new.property: " + nueva);
	}
}
