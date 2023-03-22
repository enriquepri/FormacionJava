package com.bosonit.formacion.block7crudvalidation.profesor.application;

import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.repository.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.formacion.block7crudvalidation.profesor.domain.Profesor;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.repository.ProfesorRepository;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ProfesorOutputDto profesorAdd(ProfesorInputDto profesorInputDto) {
        Persona persona = personaRepository.findById(profesorInputDto.getId_persona()).orElseThrow(
                () -> new EntityNotFoundException("No hay persona con id: " + profesorInputDto.getId_persona())
        );

        if (persona.getProfesor() != null) {
            throw new UnprocessableEntityException("La persona ya está asignada");
        }
        if (persona.getStudent() != null) {
            throw new UnprocessableEntityException("La persona es un estudiante");
        }

        Profesor profesor = new Profesor(profesorInputDto);
        profesor.setPersona(persona);
        return profesorRepository.save(profesor).profesorToProfesorOutputDto();
    }

    @Override
    public List<ProfesorOutputDto> getAllProfesors() {
        return profesorRepository.findAll().stream()
                .map(Profesor::profesorToProfesorOutputDto)
                .toList();
    }

    @Override
    public List<StudentOutputDto> getAllStudentsFromProfesor(int profesor_id) {
        Profesor profesor = profesorRepository.findById(profesor_id).orElseThrow(
                () -> new EntityNotFoundException("No existe profesor con id: " + profesor_id)
        );

        return profesor.getStudents().stream()
                .map(Student::studentToStudentOutputDto)
                .toList();
    }

    @Override
    public void addStudentToProfesor(int profesor_id, int student_id) {
        Profesor profesor = profesorRepository.findById(profesor_id).orElseThrow(
                () -> new EntityNotFoundException("No existe profesor con el id: " + profesor_id)
        );

        Student student = studentRepository.findById(student_id).orElseThrow(
                () -> new EntityNotFoundException("No existe alumno con el id: " + student_id)
        );
        if (student.getProfesor() != null) {
            throw new UnprocessableEntityException("El estudiante ya tiene profesor");
        }

        student.setProfesor(profesor);
        profesor.getStudents().add(student);

        studentRepository.save(student);
        profesorRepository.save(profesor);
    }

    @Override
    public void deleteProfesorById(Integer profesor_id) {
        Profesor profesor = profesorRepository.findById(profesor_id).orElseThrow(
                () -> new EntityNotFoundException("No existe profesor con la id: " + profesor_id)
        );

        if(!profesor.getStudents().isEmpty()){
            for(Student s : profesor.getStudents()){
                s.setProfesor(null);
                studentRepository.save(s);
            }
        }

        profesorRepository.delete(profesor);
    }
}
