package com.bosonit.formacion.block5profiles;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Block5ProfilesApplication {
	@Autowired
	Environment env;

	@Value("${bd.url}")
	private String url;

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

	@PostConstruct
	private void postConstruct(){
		System.out.println(env);
		System.out.println("La url es: " + url);
	}

	@Bean
	CommandLineRunner ejecutame()
	{
		return p ->
		{
			for(String arg : p){
				System.out.println("Argumento: " + arg);
			}
		};
	}

}
