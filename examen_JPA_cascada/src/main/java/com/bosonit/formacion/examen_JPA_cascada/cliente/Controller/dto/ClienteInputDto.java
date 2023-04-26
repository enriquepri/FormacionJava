package com.bosonit.formacion.examen_JPA_cascada.cliente.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteInputDto {
    Integer id;
    String nombre;
}
