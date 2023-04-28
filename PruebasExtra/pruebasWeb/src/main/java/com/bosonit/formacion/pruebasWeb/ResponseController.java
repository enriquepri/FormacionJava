package com.bosonit.formacion.pruebasWeb;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @GetMapping(value = "/hola")
    public String saludo(){
        return "Hola que tal";
    }

    @GetMapping(value = "/ok")
    public ResponseEntity<String> ok(){
        return new ResponseEntity<>(HttpStatus.OK + ": Respuesta correcta", HttpStatus.OK);
    }

    @GetMapping(value = "/notfound")
    public ResponseEntity<String> notFound(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND + ": Recurso no encontrado",
                HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/teapot")
    public ResponseEntity<String> teapot(){
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT + ": No estoy hecho para esto",
                HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping(value = "/header")
    public ResponseEntity<String> header(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Hello", "World!");
        headers.add("Web", "Estamos en la web");
        return new ResponseEntity<>(HttpStatus.OK + ": Aqui tienes tus headers",
                headers,
                HttpStatus.OK);
    }

    @GetMapping(value = "/ok2")
    public ResponseEntity<String> ok2(){
        return ResponseEntity.ok(HttpStatus.OK + ": Respuesta corecta");
    }

    @GetMapping(value = "/headers2")
    public ResponseEntity<String> header2(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Header1", "Este es el header1");
        return ResponseEntity.ok().headers(headers).body(HttpStatus.OK + ": Mandando los headers");
    }

    @GetMapping(value = "/badRequest")
    public ResponseEntity<String> badRequest(){
        return ResponseEntity.badRequest().body("Bad request");
    }

    @GetMapping(value = "/notFound2")
    public ResponseEntity<String> notFound2(){
        return ResponseEntity.status(404).body("Recurso no encontrado");
    }

    @GetMapping(value = "/imateapot")
    public ResponseEntity<String> imATeaPot(){
        return ResponseEntity.status(418).body("No soy una cafetera");
    }

    @GetMapping(value = "/internalServerError")
    public ResponseEntity<String> internarServerError(){
        return ResponseEntity.status(500).body("Has vuelto a petar el servidor");
    }
}
