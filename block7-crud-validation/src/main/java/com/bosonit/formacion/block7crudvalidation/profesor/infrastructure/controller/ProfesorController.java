package com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller;

import com.bosonit.formacion.block7crudvalidation.profesor.application.ProfesorService;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @PostMapping("/addProfesor")
    public ResponseEntity<ProfesorOutputDto> addProfesor(
            @RequestBody ProfesorInputDto profesorInputDto
    ) {
        return ResponseEntity.ok().body(profesorService.profesorAdd(profesorInputDto));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudentToProfesor(
            @RequestParam int profesor_id,
            @RequestParam int student_id
    ) {
        profesorService.addStudentToProfesor(profesor_id, student_id);
        return ResponseEntity.ok("Añadido estudiante");
    }

    @GetMapping("/getAllProfesors")
    public ResponseEntity<Iterable<ProfesorOutputDto>> getAllProfesors() {
        return ResponseEntity.ok()
                .body(profesorService.getAllProfesors());
    }

    @GetMapping("/getStudents/{profesor_id}")
    public ResponseEntity<Iterable<StudentOutputDto>> getStudentsByProfesor(
            @PathVariable int profesor_id
    ) {
        return ResponseEntity.ok()
                .body(profesorService.getAllStudentsFromProfesor(profesor_id));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable Integer id
    ) {
        profesorService.deleteProfesorById(id);
        return ResponseEntity.ok("Profesor eliminado");
    }
}
