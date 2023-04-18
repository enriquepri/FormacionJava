package com.bosonit.formacion.block10dockerizeapp;

import com.bosonit.formacion.block10dockerizeapp.application.StudentService;
import com.bosonit.formacion.block10dockerizeapp.controller.dto.StudentInputDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CambiarFuenteBDApplication {

	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(CambiarFuenteBDApplication.class, args);
	}

	@PostConstruct
	private void postConstruct(){
		studentService.addStudent(new StudentInputDto(
				1,
				"Juan",
				"Perez"
		));
	}
}
