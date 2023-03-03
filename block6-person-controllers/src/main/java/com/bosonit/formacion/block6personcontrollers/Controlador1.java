package com.bosonit.formacion.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {
    @Autowired
    CollectionBeans coleccion;

    @GetMapping("/addPersonaPrueba")
    public ResponseEntity<String> addPersonaPrueba(@RequestHeader("nombre") String nombre,
                                             @RequestHeader("ciudad") String ciudad,
                                             @RequestHeader("edad") int edad){
        String respuesta = "\nNombre: " + nombre + "\nCiudad: " + ciudad + "\nEdad: " + edad;
        return ResponseEntity.ok(HttpStatus.OK + respuesta);
    }

    @GetMapping("/addPersona")
    public ResponseEntity<Persona> addPersona(@RequestHeader("nombre") String nombre,
                                             @RequestHeader("ciudad") String ciudad,
                                             @RequestHeader("edad") int edad){
        Persona person = new Persona(nombre, ciudad, edad);
        coleccion.person = person;
        return ResponseEntity.ok(person);
    }

    @PostMapping("addCiudad")
    public ResponseEntity<String> addCiudad(@RequestBody Ciudad ciudad){
        coleccion.listaCiudades.add(ciudad);
        return ResponseEntity.ok(HttpStatus.OK + ": Ciudad añadida");
    }
}
