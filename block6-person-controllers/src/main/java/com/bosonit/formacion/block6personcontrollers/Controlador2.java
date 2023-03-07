package com.bosonit.formacion.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    @Autowired
    @Qualifier("miPersona")
    Persona person;
    @Autowired
    List<Ciudad> listaCiudades;

    @Autowired
    @Qualifier("bean1")
    Persona bean1;

    @Autowired
    @Qualifier("bean2")
    Persona bean2;

    @Autowired
    @Qualifier("bean3")
    Persona bean3;

    @GetMapping("/getPersona")
    public ResponseEntity<Persona> getPersona(){
        //Persona persona = new Persona(person.nombre, person.ciudad, person.edad * 2);
        return ResponseEntity.ok(person);

    }

    @GetMapping("/getCiudad")
    public ResponseEntity<List<Ciudad>> getCiudad(){
        return ResponseEntity.ok(listaCiudades);
    }

    @GetMapping("/bean/{bean}")
    @ResponseBody
    public ResponseEntity<Persona> bean(@PathVariable String bean){
        switch (bean){
            case "bean1":
                return ResponseEntity.ok(bean1);
            case "bean2":
                return ResponseEntity.ok(bean2);
            case "bean3":
                return ResponseEntity.ok(bean3);
            default:
                //return ResponseEntity.internalServerError(new Persona());
                //return ResponseEntity.badRequest().body(new Persona());
                return ResponseEntity.badRequest().build();
        }
    }
}
