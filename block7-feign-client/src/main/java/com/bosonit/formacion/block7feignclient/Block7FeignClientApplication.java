package com.bosonit.formacion.block7feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Block7FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block7FeignClientApplication.class, args);
	}

}
