package com.bosonit.formacion.block7feignclient.profesor.controller;

import com.bosonit.formacion.block7feignclient.profesor.client.ProfesorFeignClient;
import com.bosonit.formacion.block7feignclient.profesor.domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
public class Controller {
    @Autowired
    ProfesorFeignClient profesorFeignClient;

    @GetMapping("/profesor/{id}")
    public ResponseEntity<Profesor> getProfesor(
            @PathVariable("id") Integer profesor_id
    ) {
        return ResponseEntity.ok().body(profesorFeignClient.getProfesor(profesor_id));
    }

    @PostMapping("/profesor")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Profesor> addProfesor(
            @RequestBody Profesor profesor
    ) {
        return profesorFeignClient.addProfesor(profesor);
    }

    @PostMapping("/profesorVacio")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Profesor> addProfesorVacio() {
        Profesor profesor = new Profesor(0, 1, "Comentario vacio", "Palo");
        return profesorFeignClient.addProfesor(profesor);
    }

    @PutMapping("/profesor/{id}")
    public ResponseEntity<Profesor> updateProfesor(
            @PathVariable(value = "id") Integer profesor_id,
            @RequestBody Profesor profesor
    ) {
        profesor.setId(profesor_id);
        return profesorFeignClient.updateProfesor(profesor);
    }
}
