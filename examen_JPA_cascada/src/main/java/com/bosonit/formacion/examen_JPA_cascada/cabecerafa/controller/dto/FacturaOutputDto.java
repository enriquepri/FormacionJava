package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto;

import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto.LineaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaOutputDto {
    Integer id;
    Double importe;
    ClienteOutputDto clienteOutputDto;
    List<LineaOutputDto> lineas;
}
