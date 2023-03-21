package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputStudentDto extends PersonaOutputDto{
    Integer student_id;
    int num_hours_week;
    String comments;
    String branch;
    Integer profesor_id;

    public PersonaOutputStudentDto(Persona persona) {
        super(persona);
        this.student_id = persona.getStudent().getId();
        this.num_hours_week = persona.getStudent().getNum_hours_week();
        this.comments = persona.getStudent().getComments();
        this.branch = persona.getStudent().getBranch();
        this.profesor_id = persona.getStudent().getProfesor()!=null ?
                persona.getStudent().getProfesor().getId() : -1;
    }
}
