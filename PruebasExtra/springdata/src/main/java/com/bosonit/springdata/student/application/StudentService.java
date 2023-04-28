package com.bosonit.springdata.student.application;

import com.bosonit.springdata.student.controller.dto.StudentInputDto;
import com.bosonit.springdata.student.controller.dto.StudentOutputDto;

public interface StudentService {
    StudentOutputDto addStudent(StudentInputDto student);
    StudentOutputDto getStudentById(int id);
    void deleteStudentById(int id);
    Iterable<StudentOutputDto> getAllStudents (int pageNumber, int pageSize);
    StudentOutputDto updateStudent (StudentInputDto student);
}
