package com.bosonit.formacion.block7crudvalidation.asignatura.application;

import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.repository.AsignaturaRepository;
import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        Student student = studentRepository.findById(asignaturaInputDto.getId_alumno()).orElseThrow(
                () -> new EntityNotFoundException("No existe alumno con id: " + asignaturaInputDto.getId_alumno())
        );

        Asignatura asignatura = new Asignatura(asignaturaInputDto);
        asignatura.setStudent(student);
        asignatura.setInitial_date(new Date());
        //Falta añadir la finish date
        student.getAsignaturas().add(asignatura);

        studentRepository.save(student);
        return asignaturaRepository.save(asignatura).asignaturaToAsignaturaOutputDto();
    }

    @Override
    public List<AsignaturaOutputDto> getAllAsignaturas() {
        return asignaturaRepository.findAll().stream()
                .map(Asignatura::asignaturaToAsignaturaOutputDto)
                .toList();
    }

    @Override
    public Iterable<AsignaturaOutputDto> getAsignaturasFromStudent(Integer student_id) {
        Student student = studentRepository.findById(student_id).orElseThrow(
                () -> new EntityNotFoundException("No existe alumno con id: " + student_id)
        );

        return asignaturaRepository.findAll().stream()
                .filter(asignatura -> asignatura.getStudent() == student)
                .map(Asignatura::asignaturaToAsignaturaOutputDto)
                .toList();
    }
}
