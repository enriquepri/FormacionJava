package com.bosonit.formacion.block7crudvalidation.controller;


import com.bosonit.formacion.block7crudvalidation.application.PersonaService;
import com.bosonit.formacion.block7crudvalidation.application.PersonaServiceImpl;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class Controller {
    @Autowired
    PersonaService personaService;

    @PostMapping("/addPersona")
    public ResponseEntity<PersonaOutputDto> addPersona(
            @RequestBody PersonaInputDto personaInputDto
            ) {
        return ResponseEntity.ok(personaService.addPersona(personaInputDto));
    }

    @GetMapping("/getAll")
    public Iterable<PersonaOutputDto> getAllPersonas(){
        return personaService.getAllPersonas();
    }

    @GetMapping("/usuario/{user}")
    public ResponseEntity<PersonaOutputDto> getByUsuario(
            @PathVariable String user
    ){
        return ResponseEntity.ok().body(personaService.getPersonaByUsername(user));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonaOutputDto> getByID(
            @PathVariable int id
    ){
        return ResponseEntity.ok().body(personaService.getPersonaById(id));
    }
}
