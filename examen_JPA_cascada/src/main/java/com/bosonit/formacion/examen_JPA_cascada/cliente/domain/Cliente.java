package com.bosonit.formacion.examen_JPA_cascada.cliente.domain;

import com.bosonit.formacion.examen_JPA_cascada.cliente.Controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.Controller.dto.ClienteOutputDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false, length = 100)
    String nombre;

    public Cliente(ClienteInputDto clienteInputDto){
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
