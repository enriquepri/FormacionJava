package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaInputDto {
    Integer id;
    Integer clienteid;
    Double importeFa;
}
