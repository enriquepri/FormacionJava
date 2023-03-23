package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputAsignaturas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputStudentDto extends PersonaOutputDto{
    StudentOutputAsignaturas student;

    public PersonaOutputStudentDto(Persona persona) {
        super(persona);
        this.student = new StudentOutputAsignaturas(persona.getStudent());
    }
}
