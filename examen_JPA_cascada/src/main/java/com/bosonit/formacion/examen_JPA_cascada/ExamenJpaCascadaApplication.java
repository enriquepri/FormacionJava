package com.bosonit.formacion.examen_JPA_cascada;

import com.bosonit.formacion.examen_JPA_cascada.cliente.Controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.application.ClienteService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamenJpaCascadaApplication {
	@Autowired
	ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(ExamenJpaCascadaApplication.class, args);
	}

	@PostConstruct
	public void nuevaEjecucion(){
		ClienteInputDto c = new ClienteInputDto(22, "Jaime");
		clienteService.addCliente(c);
	}
}
