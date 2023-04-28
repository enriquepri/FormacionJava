package com.bosonit.springdata.school.controller;

import com.bosonit.springdata.school.application.SchoolService;
import com.bosonit.springdata.school.controller.dto.SchoolInputDto;
import com.bosonit.springdata.school.controller.dto.SchoolOutputDto;
import com.bosonit.springdata.student.controller.dto.StudentOutputDto;
import com.bosonit.springdata.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping
    public ResponseEntity<SchoolOutputDto> addSchool(@RequestBody SchoolInputDto schoolInputDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                schoolService.addSchool(schoolInputDto)
        );
    }

    @PostMapping("/student")
    public ResponseEntity<String> addStudentToSchool(
            @RequestParam int student_id,
            @RequestParam int school_id
    ){
        try{
            schoolService.addStudentToSchool(student_id, school_id);
            return ResponseEntity.ok().body("Student: " + student_id + " added to school: " + school_id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping("/getStudents")
    public Iterable<String> getAllStudents(
            @RequestParam int school_id
    ){
        return schoolService.getAllStudents(school_id);
    }

    @GetMapping("/getDtos")
    public Iterable<StudentOutputDto> getDtos(
            @RequestParam int school_id
    ){
        return schoolService.getDtos(school_id);
    }
}
