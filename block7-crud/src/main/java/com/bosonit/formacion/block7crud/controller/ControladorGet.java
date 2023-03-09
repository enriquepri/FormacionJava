package com.bosonit.formacion.block7crud.controller;

import com.bosonit.formacion.block7crud.application.PersonaServiceImpl;
import com.bosonit.formacion.block7crud.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorGet {
    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping
    public ResponseEntity<List> getAll(){
        List<Persona> lista = personaService.getAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(
            @PathVariable int id
    ){
        try{
            return ResponseEntity.ok().body(personaService.getPersonaById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public  ResponseEntity<List> getPersonasByNombre(
            @PathVariable String nombre
    ){
        return  ResponseEntity.ok().body(personaService.getAllByName(nombre));
    }
}
