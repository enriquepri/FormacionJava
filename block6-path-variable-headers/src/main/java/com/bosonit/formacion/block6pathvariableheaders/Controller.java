package com.bosonit.formacion.block6pathvariableheaders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    @PostMapping("/postPersona")
    @ResponseBody
    public ResponseEntity<Person> postPersona(@RequestBody Person person){
        Person persona = new Person(person.getEdad(), person.getNombre());
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> user(@PathVariable int id){
        return ResponseEntity.ok("El id recibido es: " + id);
    }

    @PutMapping("/post")
    @ResponseBody
    public ResponseEntity<List> post(@RequestParam (defaultValue = "1") int var1,
                                        @RequestParam (defaultValue = "2") int var2){
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("var1", var1);
        HashMap<String, Integer> mapa2 = new HashMap<>();
        mapa2.put("var2", var2);
        List<HashMap> lista = new ArrayList<>();
        lista.add(mapa2);
        lista.add(mapa);
        return ResponseEntity.ok(lista);
    }
}
