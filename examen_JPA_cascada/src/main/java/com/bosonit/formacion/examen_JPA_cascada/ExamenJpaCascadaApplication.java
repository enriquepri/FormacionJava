package com.bosonit.formacion.examen_JPA_cascada;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.application.FacturaService;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.application.ClienteService;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto.LineaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExamenJpaCascadaApplication {
	@Autowired
	ClienteService clienteService;

	@Autowired
	FacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ExamenJpaCascadaApplication.class, args);
	}

	@Bean
	CommandLineRunner ejecutame()
	{
		return p ->
		{
			ClienteInputDto c = new ClienteInputDto(1, "Jaime");
			clienteService.addCliente(c);

			List<LineaInputDto> lineas = new ArrayList<>();
			lineas.add(new LineaInputDto(0, "Melon", 1, 3.14));
			lineas.add(new LineaInputDto(0, "Sandia", 2, 2.67));

			FacturaInputDto f = new FacturaInputDto(0, 1, 22.98);
			facturaService.addFactura(f, lineas);
		};
	}
}
