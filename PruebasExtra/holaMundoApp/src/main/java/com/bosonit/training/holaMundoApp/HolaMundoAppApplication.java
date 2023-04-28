package com.bosonit.training.holaMundoApp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@SpringBootApplication
@PropertySource("classpath:foo.properties")
public class HolaMundoAppApplication {

	@Bean
	CommandLineRunner ejecutame()
	{
		return p ->
		{
			System.out.println("Linea a ejecutar cuando arranque");
		};
	}

	@Autowired
	ClasePrueba prueba;

	@Value("${greeting:un saludo}")
	private String saludo;
	@Value("${my.number:50}")
	private int numero;

	@Value("#{systemProperties}")
	private Map<String, String> propiedadesDelSistema;

	@Value("${varSistema:Fallo}")
	private String varSistema;

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoAppApplication.class, args);
		System.out.println("Hello world");
	}

	@PostConstruct
	private void loPrimero(){
		System.out.println("Hola desde la clase principal");
		System.out.println(saludo);
		System.out.println("El numero es: " + numero);
		//propiedadesDelSistema.forEach((key, value) -> System.out.println(key + ":" + value));
		System.out.println("La variable del sistema es: " + varSistema);
	}

	@PreDestroy
	private void creoQueUltimo(){
		System.out.println("Lo del PreDestroy");
	}

}
