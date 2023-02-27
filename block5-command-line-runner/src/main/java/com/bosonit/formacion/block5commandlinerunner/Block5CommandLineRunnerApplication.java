package com.bosonit.formacion.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Block5CommandLineRunnerApplication {

	@Autowired
	ClaseSecundaria secun;

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
		System.out.println("Hola mundo");
	}

	@Bean
	CommandLineRunner ejecutame()
	{
		return p ->
		{
			System.out.println("Linea a ejecutar cuando arranque");
			for (String argu : p){
				System.out.println("Argumento Bean: " + argu);
			}
		};
	}

	@PostConstruct
	private void postConstruct(){
		System.out.println("Linea del PostConstruct");
	}

	@PreDestroy
	private void preDestroy(){
		System.out.println("Linea del PreDestroy");
	}
}
