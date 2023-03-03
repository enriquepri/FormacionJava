package com.bosonit.formacion.block6simplecontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MiControlador {
    @GetMapping("/user/{nombre}")
    public ResponseEntity<String> user(@PathVariable String nombre){
        return ResponseEntity.ok("Hola " + nombre);
    }
}
