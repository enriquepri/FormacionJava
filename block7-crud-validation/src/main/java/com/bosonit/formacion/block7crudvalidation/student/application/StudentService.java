package com.bosonit.formacion.block7crudvalidation.student.application;

import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDtoCompleto;

public interface StudentService {
    StudentOutputDtoCompleto studentAdd(StudentInputDto studentInputDto);
    Iterable<StudentOutputDto> getAllStudents();
    StudentOutputDto getStudentById(Integer id, String outputType);
    void deleteStudentById(Integer id);
}
