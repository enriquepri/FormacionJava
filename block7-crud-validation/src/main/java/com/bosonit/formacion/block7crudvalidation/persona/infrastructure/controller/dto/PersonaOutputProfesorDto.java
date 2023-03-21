package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputProfesorDto extends PersonaOutputDto{
    Integer profesor_id;
    String comments;
    String branch;

    public PersonaOutputProfesorDto(Persona persona) {
        super(persona);
        this.profesor_id = persona.getProfesor().getId();
        this.comments = persona.getProfesor().getComments();
        this.branch = persona.getProfesor().getBranch();
    }
}
