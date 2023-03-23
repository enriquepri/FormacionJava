package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputAsignaturas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputProfesorDto extends PersonaOutputDto{
    ProfesorOutputDto profesor;
    List<StudentOutputAsignaturas> students;

    public PersonaOutputProfesorDto(Persona persona) {
        super(persona);
        this.profesor = persona.getProfesor().profesorToProfesorOutputDto();
        this.students = persona.getProfesor().getStudents()
                .stream()
                .map(s -> new StudentOutputAsignaturas(s))
                .toList();
    }
}
