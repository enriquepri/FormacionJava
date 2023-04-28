package com.bosonit.springdata.student.application;

import com.bosonit.springdata.student.controller.dto.StudentInputDto;
import com.bosonit.springdata.student.controller.dto.StudentOutputDto;
import com.bosonit.springdata.student.domain.Student;
import com.bosonit.springdata.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutputDto addStudent(StudentInputDto student) {
        return studentRepository.save(new Student(student)).studentToStudentOutputDTO();
    }

    @Override
    public StudentOutputDto getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow().studentToStudentOutputDTO();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<StudentOutputDto> getAllStudents(int pageNumber, int pageSize) {
        PageRequest pageRequest  = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::studentToStudentOutputDTO).toList();
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto student) {
        studentRepository.findById(student.getId()).orElseThrow();
        return studentRepository.save(new Student(student)).studentToStudentOutputDTO();
    }
}
