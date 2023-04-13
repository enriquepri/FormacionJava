package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller;

import com.bosonit.formacion.block7crudvalidation.persona.application.PersonaService;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ControllerCORS {
    @Autowired
    PersonaService personaService;

    //SECCION EJERCICIO BLOQUE 11 CORS
    @CrossOrigin(origins = "https://cdpn.io")
    @PostMapping("/addperson")
    public ResponseEntity<PersonaOutputDto> addPerson(
            @RequestBody PersonaInputDto personaInputDto
    ) {
        return ResponseEntity.ok(personaService.addPersona(personaInputDto));
    }

    //@CrossOrigin(origins = "https://cdpn.io")
    @GetMapping("/getall")
    public Iterable<PersonaOutputDto> getAllPersonas() {
        return personaService.getAllPersonas();
    }
}
