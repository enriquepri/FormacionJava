package com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDto {
    Integer id;
    String nombre;
}
