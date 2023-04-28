package com.bosonit.formacion.pruebasWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/miControlador")
public class MiControlador {
    @GetMapping(value= "/hola/{whatever}")
    public String hola(@PathVariable String whatever) {
        return "Hello World " + whatever;
    }

    /*@GetMapping(value= "/hola/{whatever}/{segundoValor}")
    public String hola(@PathVariable(value="whatever") String hola, @PathVariable String segundoValor) {
        return "Hello World " + hola + " " + segundoValor;
    }*/

    @GetMapping(value= "/hola/{whatever}/{segundoValor}")
    public String hola(@PathVariable Map<String, String> mapaValores) {
        return "Hello World " + mapaValores.get("whatever") + " " + mapaValores.get("segundoValor");
    }

    @GetMapping(value = { "/api/hola2", "/api/hola2/{id}" })
    public String holaOpcional(@PathVariable(required = false) String id) {
        return id == null ? "Hello World" : "Hello World" + id;
    }

}
