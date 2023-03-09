package com.bosonit.formacion.block7crud.controller;

import com.bosonit.formacion.block7crud.application.PersonaService;
import com.bosonit.formacion.block7crud.application.PersonaServiceImpl;
import com.bosonit.formacion.block7crud.domain.Persona;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class ControladorPost {
    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<Persona> addPersona(
            @Valid @RequestBody Persona persona
    ){
        if(persona.getId() != 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.addPersona(persona));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
