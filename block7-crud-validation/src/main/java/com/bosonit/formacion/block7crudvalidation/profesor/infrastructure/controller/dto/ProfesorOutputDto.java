package com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDto {
    private int id;
    private int id_persona;
    private String comments;
    private String branch;

    public ProfesorOutputDto(Profesor profesor) {
        this.id = profesor.getId();
        this.id_persona = profesor.getPersona().getId_persona();
        this.comments = profesor.getComments();
        this.branch = profesor.getBranch();
    }
}
