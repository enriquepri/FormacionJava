package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller;


import com.bosonit.formacion.block7crudvalidation.persona.application.PersonaService;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/persona")
public class Controller {
    @Autowired
    PersonaService personaService;

    @PostMapping("/addPersona")
    public ResponseEntity<PersonaOutputDto> addPersona(
            @RequestBody PersonaInputDto personaInputDto
    ) {
        return ResponseEntity.ok(personaService.addPersona(personaInputDto));
    }

    @GetMapping("/getAll")
    public Iterable<PersonaOutputDto> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/usuario/{user}")
    public ResponseEntity<PersonaOutputDto> getByUsuario(
            @PathVariable String user,
            @RequestParam(defaultValue = "simple") String outputType
    ) {
        return ResponseEntity.ok().body(personaService.getPersonaByUsername(user, outputType));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonaOutputDto> getByID(
            @PathVariable int id,
            @RequestParam(defaultValue = "simple") String outputType
    ) {
        return ResponseEntity.ok().body(personaService.getPersonaById(id, outputType));
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable int id
    ) {
        personaService.deletePersonaById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Persona borrada con éxito");
    }

    @DeleteMapping("/deleteUsername/{username}")
    public ResponseEntity<String> deleteByUsername(
            @PathVariable String username
    ) {
        personaService.deletePersonaByUsername(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Persona borrada con éxito");
    }

    @PutMapping("/update")
    public ResponseEntity<PersonaOutputDto> updatePersona(@RequestBody PersonaInputDto personaInputDto) {
        return ResponseEntity.ok().body(personaService.updatePersona(personaInputDto));
    }

    /*
    Request Mapping
     */
    @GetMapping("/profesor/{id}")
    public ProfesorOutputDto getProfesor(
            @PathVariable Integer id
    ) {
        ResponseEntity<ProfesorOutputDto> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8080/profesor/"+id, ProfesorOutputDto.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();
        throw new RuntimeException("The server didn't respond OK");
    }
}
