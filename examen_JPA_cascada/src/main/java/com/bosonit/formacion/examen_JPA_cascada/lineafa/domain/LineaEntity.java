package com.bosonit.formacion.examen_JPA_cascada.lineafa.domain;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain.FacturaEntity;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto.LineaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto.LineaOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineaEntity {
    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    @JoinColumn(name = "IdFra")
    FacturaEntity factura;
    String proNomb;
    double cantidad;
    double precio;

    public LineaEntity(LineaInputDto lineaInputDto){
        this.id = lineaInputDto.getId();
        this.factura = lineaInputDto.getFactura();
        this.proNomb = lineaInputDto.getProNomb();
        this.cantidad = lineaInputDto.getCantidad();
        this.precio = lineaInputDto.getPrecio();
    }

    public LineaEntity(Integer id, String proNomb, double cantidad, double precio) {
        this.id = id;
        this.proNomb = proNomb;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public LineaOutputDto lineaToLineaOutputDto(){
        return new LineaOutputDto(
                this.id,
                this.proNomb,
                this.cantidad,
                this.precio
        );
    }
}
