package com.bosonit.formacion.block7crudvalidation.asignatura.application;

import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.repository.AsignaturaRepository;
import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        Optional<Asignatura> comprobar = asignaturaRepository.findByNombre(asignaturaInputDto.getNombre());
        if (comprobar.isPresent())
            throw new UnprocessableEntityException("Ya existe una asignatura con el nombre: "
                    + asignaturaInputDto.getNombre());

        Asignatura asignatura = new Asignatura(asignaturaInputDto);
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

        return student.getAsignaturas().stream()
                .map(Asignatura::asignaturaToAsignaturaOutputDto)
                .toList();
    }

    @Override
    public void addStudentToAsignatura(List<Integer> asignaturas_ids, int student_id) {
        Student student = studentRepository.findById(student_id).orElseThrow(
                () -> new EntityNotFoundException("No existe alumno con id: " + student_id)
        );

        List<Asignatura> listaAgregar = new ArrayList<>();
        for (Integer i : asignaturas_ids) {
            if(i == null){
                throw new UnprocessableEntityException("Valor de asignaturas no valido");
            }
            listaAgregar.add(asignaturaRepository.findById(i).orElseThrow(
                            () -> new EntityNotFoundException("No existe asignatura con la id: " + i)
                    )
            );
        }

        for (Asignatura asignatura : listaAgregar) {
            student.getAsignaturas().add(asignatura);
        }

        studentRepository.save(student);
    }

    @Override
    public void deleteById(Integer asignatura_id) {
        Asignatura asignaturaBorrar = asignaturaRepository.findById(asignatura_id).orElseThrow(
                () -> new EntityNotFoundException("No hay asignatura con la id: " + asignatura_id)
        );

        if (!asignaturaBorrar.getStudents().isEmpty()) {
            for (Student s : asignaturaBorrar.getStudents()) {
                s.getAsignaturas().remove(asignaturaBorrar);
                //studentRepository.save(s);
            }
        }

        asignaturaRepository.delete(asignaturaBorrar);
    }

    @Override
    public AsignaturaOutputDto updateAsignatura(AsignaturaInputDto asignaturaInputDto) {
        Asignatura asignatura = asignaturaRepository.findById(asignaturaInputDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("No existe la asignatura con id: " + asignaturaInputDto.getId())
        );

        if (asignaturaInputDto.getNombre() != null && !asignaturaInputDto.getNombre().isEmpty())
            asignatura.setNombre(asignaturaInputDto.getNombre());
        if (asignaturaInputDto.getComments() != null && !asignaturaInputDto.getComments().isEmpty())
            asignatura.setComments(asignaturaInputDto.getComments());

        return asignaturaRepository.save(asignatura).asignaturaToAsignaturaOutputDto();
    }

    @Override
    public void removeAsignaturasFromStudent(List<Integer> asignaturas_ids, int student_id) {
        Student student = studentRepository.findById(student_id).orElseThrow(
                () -> new EntityNotFoundException("No hay estudiante con el id: " + student_id)
        );

        for(Integer i : asignaturas_ids){
            if(i == null) continue;
            Asignatura asignaturaQuitar = asignaturaRepository.findById(i).orElseThrow(
                    () -> new EntityNotFoundException("No hay asignatura con el id: " + i)
            );

            if(student.getAsignaturas().contains(asignaturaQuitar))
                student.getAsignaturas().remove(asignaturaQuitar);
        }

        studentRepository.save(student);
    }
}
