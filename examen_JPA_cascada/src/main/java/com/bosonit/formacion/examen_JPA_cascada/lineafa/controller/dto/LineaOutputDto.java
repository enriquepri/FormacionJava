package com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaOutputDto {
    Integer id;
    String proNomb;
    double cantidad;
    double precio;
}
