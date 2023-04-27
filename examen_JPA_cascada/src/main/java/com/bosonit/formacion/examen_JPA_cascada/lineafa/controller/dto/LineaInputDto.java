package com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain.FacturaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaInputDto {
    Integer id;
    FacturaEntity factura;
    String proNomb;
    double cantidad;
    double precio;

    public LineaInputDto(Integer id, String proNomb, double cantidad, double precio) {
        this.id = id;
        this.proNomb = proNomb;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
