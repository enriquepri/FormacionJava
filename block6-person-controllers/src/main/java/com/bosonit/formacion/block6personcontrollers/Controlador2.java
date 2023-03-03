package com.bosonit.formacion.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    @Autowired
    CollectionBeans coleccion;

    @GetMapping("/getPersona")
    public ResponseEntity<Persona> getPersona(){
        if(coleccion.person != null){
            Persona person = new Persona(coleccion.person.nombre, coleccion.person.ciudad, coleccion.person.edad * 2);
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.status(400).body(null);
    }
}
