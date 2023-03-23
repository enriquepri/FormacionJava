package com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputAsignaturas extends StudentOutputDto{
    List<AsignaturaOutputDto> asignaturas;

    public StudentOutputAsignaturas(Student student) {
        super(student);
        this.asignaturas = student.getAsignaturas().stream()
                .map(Asignatura::asignaturaToAsignaturaOutputDto)
                .toList();
    }
}
