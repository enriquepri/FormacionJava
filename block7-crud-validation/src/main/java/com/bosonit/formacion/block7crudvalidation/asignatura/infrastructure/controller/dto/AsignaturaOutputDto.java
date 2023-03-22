package com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDto {
    Integer id;
    String nombre;
    String comments;
    //Date initial_date;
    //Date finish_date;

    public AsignaturaOutputDto(Asignatura asignatura) {
        this.id = asignatura.getId();
        this.nombre = asignatura.getNombre();
        this.comments = asignatura.getComments();
        //this.initial_date = asignatura.getInitial_date();
        //this.finish_date = asignatura.getFinish_date();
    }
}
