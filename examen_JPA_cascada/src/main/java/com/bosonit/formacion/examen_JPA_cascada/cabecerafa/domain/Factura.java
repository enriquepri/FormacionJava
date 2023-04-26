package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.domain.Linea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    @JoinColumn(name = "cli_codi")
    Cliente cliente;
    Double importeFa;
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    List<Linea> lineas = new ArrayList<>();

    public Factura (FacturaInputDto facturaInputDto){
        this.id = facturaInputDto.getId();
        this.importeFa = facturaInputDto.getImporteFa();
    }

    public FacturaOutputDto facturaToFacturaOutputDto(){
        return new FacturaOutputDto(
                this.id,
                this.importeFa,
                this.cliente.clienteToClienteOutputDto(),
                this.lineas.stream().map(Linea::lineaToLineaOutputDto).toList()
        );
    }
}
