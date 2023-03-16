package com.bosonit.formacion.block7crudvalidation.student.controller;

import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.student.application.StudentService;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDtoCompleto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<StudentOutputDtoCompleto> addStudent(@RequestBody StudentInputDto studentInputDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.studentAdd(studentInputDto));
    }

    @GetMapping("/getAll")
    public Iterable<StudentOutputDtoCompleto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentOutputDto> getStudentByID(
            @PathVariable int id,
            @RequestParam (defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return ResponseEntity.ok(studentService.getStudentById(id));
        } else if (outputType.equals("full")) {
            return ResponseEntity.ok(studentService.getStudentByIdCompleto(id));
        }
        throw new UnprocessableEntityException("Las opciones disponibles son simple o full");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student eliminado");
    }
}
