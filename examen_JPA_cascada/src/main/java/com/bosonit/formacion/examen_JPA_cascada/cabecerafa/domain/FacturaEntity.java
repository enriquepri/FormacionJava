package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.ClienteEntity;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.domain.LineaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaEntity {
    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    @JoinColumn(name = "cli_codi")
    ClienteEntity cliente;
    Double importeFa;
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LineaEntity> lineas = new ArrayList<>();

    public FacturaEntity(FacturaInputDto facturaInputDto){
        this.id = facturaInputDto.getId();
        this.importeFa = facturaInputDto.getImporteFa();
    }

    public FacturaOutputDto facturaToFacturaOutputDto(){
        return new FacturaOutputDto(
                this.id,
                this.importeFa,
                this.cliente.clienteToClienteOutputDto(),
                this.lineas.stream().map(LineaEntity::lineaToLineaOutputDto).toList()
        );
    }
}
