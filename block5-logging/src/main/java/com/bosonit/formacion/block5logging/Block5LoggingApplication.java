package com.bosonit.formacion.block5logging;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5LoggingApplication {

	@Autowired
	CLaseLogs lugarLogs;

	public static void main(String[] args) {
		SpringApplication.run(Block5LoggingApplication.class, args);
	}
}
