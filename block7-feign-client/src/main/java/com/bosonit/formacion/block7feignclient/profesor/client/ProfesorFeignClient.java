package com.bosonit.formacion.block7feignclient.profesor.client;

import com.bosonit.formacion.block7feignclient.profesor.domain.Profesor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "ProfesorFeign", url = "${external.base-url}")
public interface ProfesorFeignClient {

    @GetMapping(value = "/profesor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Profesor getProfesor(@PathVariable("id") Integer id);

    @PostMapping(value = "/profesor/addProfesor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> addProfesor(@RequestBody Profesor profesor);

    @PutMapping(value = "/profesor/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> updateProfesor(@RequestBody Profesor profesor);
}
