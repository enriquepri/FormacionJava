package com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaInputDto {
    Integer id;
    String nombre;
    String comments;
}
