package com.bosonit.formacion.block10dockerizeapp.application;

import com.bosonit.formacion.block10dockerizeapp.controller.dto.StudentInputDto;
import com.bosonit.formacion.block10dockerizeapp.controller.dto.StudentOutputDto;

public interface StudentService {
    StudentOutputDto addStudent(StudentInputDto student);
    StudentOutputDto getStudentById(int id);
    void deleteStudentById( int id);
    Iterable<StudentOutputDto> getAllStudents(int pageNumber, int pageSize);
    StudentOutputDto updateStudent(StudentInputDto student);
}
