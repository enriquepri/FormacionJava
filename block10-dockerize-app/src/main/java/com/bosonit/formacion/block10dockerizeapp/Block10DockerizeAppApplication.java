package com.bosonit.formacion.block10dockerizeapp;

import com.bosonit.formacion.block10dockerizeapp.application.StudentService;
import com.bosonit.formacion.block10dockerizeapp.controller.dto.StudentInputDto;
import com.bosonit.formacion.block10dockerizeapp.domain.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block10DockerizeAppApplication {

	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Block10DockerizeAppApplication.class, args);
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
