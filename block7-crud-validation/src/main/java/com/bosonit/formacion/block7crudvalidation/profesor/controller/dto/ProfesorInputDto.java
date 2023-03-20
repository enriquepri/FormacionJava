package com.bosonit.formacion.block7crudvalidation.profesor.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDto {
    private int id;
    private int id_persona;
    private String comments;
    private String branch;
}
