package com.bosonit.formacion.block7crudvalidation;

import com.bosonit.formacion.block7crudvalidation.persona.application.PersonaService;
import com.bosonit.formacion.block7crudvalidation.persona.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.persona.repository.PersonaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Block7CrudValidationApplication {
	@Autowired
	PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudValidationApplication.class, args);
	}

	@PostConstruct
	public void postConstruct(){
		for(int i = 1; i <= 3; i++){
			PersonaInputDto p = new PersonaInputDto(
					"username" + i,
					"password",
					"name",
					"surname",
					"company_email",
					"personal_email",
					"city",
					"imagen_url"
			);

			personaService.addPersona(p);
		}
	}
}
