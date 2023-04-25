package com.bosonit.formacion.block7crudvalidation;

import com.bosonit.formacion.block7crudvalidation.persona.application.PersonaService;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaInputDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients
public class Block7CrudValidationApplication {
	@Autowired
	PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudValidationApplication.class, args);
	}

	//Seccion para ejercicio bloque 11 - CORS
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/getall").allowedOrigins("*");
			}
		};
	}

	//Para crear una serie de personas cada vez que arranque la aplicacion
	@PostConstruct
	public void postConstruct(){
		for(int i = 1; i <= 10; i++){
			PersonaInputDto p = new PersonaInputDto(
					"username" + i,
					"password",
					"name" + (10-i),
					"surname" + i,
					"company_email",
					"personal_email",
					"city",
					"imagen_url"
			);

			personaService.addPersona(p);
		}
	}

	//Creo algunas personas concretas para pruebas criteria builder
	@PostConstruct
	public void personasCB(){
		PersonaInputDto p = new PersonaInputDto(
				"pepito23",
				"password",
				"Pepe",
				"Hernandez",
				"company_email",
				"personal_email",
				"city",
				"imagen_url"
		);

		personaService.addPersona(p);

		p = new PersonaInputDto(
				"XjuanitoX",
				"password",
				"Juan",
				"Alberto",
				"company_email",
				"personal_email",
				"city",
				"imagen_url"
		);

		personaService.addPersona(p);
	}
}
