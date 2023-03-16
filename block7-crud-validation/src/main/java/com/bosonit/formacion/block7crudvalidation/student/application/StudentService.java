package com.bosonit.formacion.block7crudvalidation.student.application;

import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDtoCompleto;

public interface StudentService {
    StudentOutputDtoCompleto studentAdd(StudentInputDto studentInputDto);
    Iterable<StudentOutputDtoCompleto> getAllStudents();
    StudentOutputDtoCompleto getStudentByIdCompleto(int id);
    StudentOutputDto getStudentById(int id);
    void deleteStudentById(int id);
}
