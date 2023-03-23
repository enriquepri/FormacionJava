package com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller;

import com.bosonit.formacion.block7crudvalidation.asignatura.application.AsignaturaService;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    AsignaturaService asignaturaService;

    @PostMapping("/addAsignatura")
    public ResponseEntity<AsignaturaOutputDto> addAsignatura(
            @RequestBody AsignaturaInputDto asignaturaInputDto
    ) {
        return ResponseEntity.ok().body(
                asignaturaService.addAsignatura(asignaturaInputDto)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<AsignaturaOutputDto>> getAllAsignaturas() {
        return ResponseEntity.ok().body(
                asignaturaService.getAllAsignaturas()
        );
    }

    @GetMapping("/get/{id_student}")
    public ResponseEntity<Iterable<AsignaturaOutputDto>> getAsignaturasFromStudent(
            @PathVariable Integer id_student
    ) {
        return ResponseEntity.ok().body(
                asignaturaService.getAsignaturasFromStudent(id_student)
        );
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudentToAsignatura(
            @RequestParam Integer asignatura_id,
            @RequestParam Integer student_id
    ) {
        asignaturaService.addStudentToAsignatura(asignatura_id, student_id);
        return ResponseEntity.ok("Estudiante añadido correctamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable Integer id
    ){
        asignaturaService.deleteById(id);
        return ResponseEntity.ok("Asignatura eliminada");
    }

    @PutMapping("/update")
    public ResponseEntity<AsignaturaOutputDto> updateAsignatura(
            @RequestBody AsignaturaInputDto asignaturaInputDto
    ){
        return ResponseEntity.ok().body(asignaturaService.updateAsignatura(asignaturaInputDto));
    }
}
