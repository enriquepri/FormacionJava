package com.bosonit.formacion.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    @Autowired
    Persona person;
    @Autowired
    List<Ciudad> listaCiudades;

    @GetMapping("/getPersona")
    public ResponseEntity<Persona> getPersona(){
        Persona persona = new Persona(person.nombre, person.ciudad, person.edad * 2);
        return ResponseEntity.ok(person);

    }

    @GetMapping("/getCiudad")
    public ResponseEntity<List<Ciudad>> getCiudad(){
        return ResponseEntity.ok(listaCiudades);
    }
}
