package com.bosonit.formacion.block7crudvalidation.student.application;

import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.persona.repository.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDtoCompleto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import com.bosonit.formacion.block7crudvalidation.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public StudentOutputDtoCompleto studentAdd(StudentInputDto studentInputDto) {
        Persona person = personaRepository.findById(studentInputDto.getPersona_id()).orElseThrow(
                () -> new EntityNotFoundException("No existe persona con la id: " + studentInputDto.getPersona_id())
        );

        Optional<Student> comprobar = studentRepository.findByPersona(person);
        if (comprobar.isPresent()) {
            throw new UnprocessableEntityException("La persona ya está asignada");
        }

        Student student = new Student(studentInputDto);
        student.setPersona(person);
        return studentRepository.save(student).studentToStudentOutputDtoCompleto();
    }

    @Override
    public List<StudentOutputDtoCompleto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(Student::studentToStudentOutputDtoCompleto)
                .toList();
    }

    @Override
    public StudentOutputDtoCompleto getStudentByIdCompleto(int id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No existe student con id: " + id)
        ).studentToStudentOutputDtoCompleto();
    }

    @Override
    public StudentOutputDto getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No existe student con id: " + id)
        ).studentToStudentOutputDto();
    }

    @Override
    public void deleteStudentById(int id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No existe student con id: " + id)
        );
        studentRepository.delete(student);
    }
}
