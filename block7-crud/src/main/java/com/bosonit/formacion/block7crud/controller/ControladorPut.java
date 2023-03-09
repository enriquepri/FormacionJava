package com.bosonit.formacion.block7crud.controller;

import com.bosonit.formacion.block7crud.application.PersonaServiceImpl;
import com.bosonit.formacion.block7crud.domain.Persona;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/put")
public class ControladorPut {
    @Autowired
    PersonaServiceImpl personaService;

    @PutMapping
    public ResponseEntity<Persona> updatePersona(
            @Valid @RequestBody Persona persona
    ){
        try{
            return ResponseEntity.ok().body(personaService.updatePersona(persona));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
