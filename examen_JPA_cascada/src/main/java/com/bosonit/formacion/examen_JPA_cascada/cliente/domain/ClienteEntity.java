package com.bosonit.formacion.examen_JPA_cascada.cliente.domain;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain.FacturaEntity;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false, length = 100)
    String nombre;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    Set<FacturaEntity> facturas;

    public ClienteEntity(ClienteInputDto clienteInputDto){
        this.id = clienteInputDto.getId();
        this.nombre = clienteInputDto.getNombre();
    }

    public ClienteOutputDto clienteToClienteOutputDto(){
        return new ClienteOutputDto(
                this.id,
                this.nombre
        );
    }
}