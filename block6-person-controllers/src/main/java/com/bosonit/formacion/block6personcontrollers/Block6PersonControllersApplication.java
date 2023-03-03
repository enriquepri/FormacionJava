package com.bosonit.formacion.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Block6PersonControllersApplication {

	@Autowired
	CollectionBeans coleccion;

	public static void main(String[] args) {
		SpringApplication.run(Block6PersonControllersApplication.class, args);
	}

	@Bean
	CommandLineRunner inicializarLista(){
		return p ->
		{
			coleccion.listaCiudades = new ArrayList<>();
			System.out.println("Lista de ciudades iniciada");
		};
	}
}
