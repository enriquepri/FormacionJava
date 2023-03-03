package com.bosonit.formacion.block6simplecontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MiControlador {
    @GetMapping("/user/{nombre}")
    public ResponseEntity<String> user(@PathVariable String nombre){
        return ResponseEntity.ok("Hola " + nombre);
    }

    @PostMapping("/useradd")
    @ResponseBody
    public ResponseEntity<Persona> userAdd(@RequestBody Persona person){
        return ResponseEntity.ok().body(new Persona(person.nombre, person.poblacion, person.edad+1));
    }
}
