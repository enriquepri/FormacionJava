package com.bosonit.formacion.block7crudvalidation.student.application;

import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.repository.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDtoCompleto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if (person.getStudent() != null) {
            throw new UnprocessableEntityException("La persona ya está asignada");
        }
        if (person.getProfesor() != null) {
            throw new UnprocessableEntityException("La persona es un profesor");
        }

        Student student = new Student(studentInputDto);
        student.setPersona(person);
        return studentRepository.save(student).studentToStudentOutputDtoCompleto();
    }

    @Override
    public List<StudentOutputDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(Student::studentToStudentOutputDto)
                .toList();
    }

    @Override
    public StudentOutputDto getStudentById(Integer id, String outputType) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No existe student con id: " + id)
        );

        if (outputType.equals("simple")) return student.studentToStudentOutputDto();
        if (outputType.equals("full")) return student.studentToStudentOutputDtoCompleto();

        throw new UnprocessableEntityException("Las opciones disponibles son simple o full");
    }

    @Override
    public void deleteStudentById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No existe student con id: " + id)
        );
        studentRepository.delete(student);
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto studentInputDto) {
        Student student = studentRepository.findById(studentInputDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("No existe estudiante con la id: " + studentInputDto.getPersona_id())
        );

        if (studentInputDto.getBranch() != null && !studentInputDto.getBranch().isEmpty())
            student.setBranch(studentInputDto.getBranch());
        if (studentInputDto.getComments() != null && !studentInputDto.getComments().isEmpty())
            student.setComments(studentInputDto.getComments());
        if (studentInputDto.getNum_hours_week() > 0) student.setNum_hours_week(studentInputDto.getNum_hours_week());

        return studentRepository.save(student).studentToStudentOutputDto();
    }
}
