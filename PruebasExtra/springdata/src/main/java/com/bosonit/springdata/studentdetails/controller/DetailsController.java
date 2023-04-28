package com.bosonit.springdata.studentdetails.controller;

import com.bosonit.springdata.studentdetails.application.StudentDetailsService;
import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsInputDto;
import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    StudentDetailsService studentDetailsService;

    @PostMapping
    public ResponseEntity<StudentDetailsOutputDto> addDetailsToStudent(
            @RequestBody StudentDetailsInputDto studentDetailsInputDto
            ){
        try{
            return ResponseEntity.ok()
                    .body(studentDetailsService.addDetailsToStudent(studentDetailsInputDto));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        studentDetailsService.deleteById(id);
        return ResponseEntity.ok("Eliminado");
    }
}
