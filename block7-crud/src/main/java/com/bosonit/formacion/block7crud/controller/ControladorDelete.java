package com.bosonit.formacion.block7crud.controller;

import com.bosonit.formacion.block7crud.application.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class ControladorDelete {
    @Autowired
    PersonaServiceImpl personaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(
            @PathVariable int id
    ){
        try{
            personaService.deletePersonaById(id);
            return ResponseEntity.ok("Persona eliminada correctamente");
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
