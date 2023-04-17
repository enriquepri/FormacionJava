package com.bosonit.formacion.block11uploaddownloadfiles;

import com.bosonit.formacion.block11uploaddownloadfiles.application.FicheroService;
import com.bosonit.formacion.block11uploaddownloadfiles.application.FicheroServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class Block11UploadDownloadFilesApplication {

	@Autowired
	FicheroServiceImpl ficheroService;

	public static void main(String[] args) {
		SpringApplication.run(Block11UploadDownloadFilesApplication.class, args);
	}

	@PostConstruct
	public void postConstruct() throws IOException {
		Files.createDirectories(Paths.get("ficheros"));

		ficheroService.setRuta("ficheros");
	}

}
