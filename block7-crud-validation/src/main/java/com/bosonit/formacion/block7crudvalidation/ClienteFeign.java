package com.bosonit.formacion.block7crudvalidation;

import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="simpleFeign",url="http://localhost:8080/")
public interface ClienteFeign {
    @GetMapping("/persona/profesor/{id}")
    public ProfesorOutputDto callServer(@PathVariable("id") Integer id);
}
