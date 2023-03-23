package com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller;

import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.student.application.StudentService;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDtoCompleto;
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
    public Iterable<StudentOutputDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentOutputDto> getStudentByID(
            @PathVariable int id,
            @RequestParam (defaultValue = "simple") String outputType){
        return ResponseEntity.ok(studentService.getStudentById(id, outputType));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student eliminado");
    }

    @PutMapping("/update")
    public ResponseEntity<StudentOutputDto> updateStudent(
            @RequestBody StudentInputDto studentInputDto
    ){
        return ResponseEntity.ok().body(studentService.updateStudent(studentInputDto));
    }
}
