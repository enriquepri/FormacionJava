package com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaInputDto {
    Integer id;
    String asignatura;
    String comments;
    Integer id_alumno;
}
