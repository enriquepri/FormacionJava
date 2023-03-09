package com.bosonit.formacion.block7crud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    int id;
    @NotBlank(message = "Nombre Obligatorio")
    String nombre;
    @NotBlank(message = "Edad obligatoria")
    String edad;
    @NotBlank(message = "Poblacion obligatoria")
    String poblacion;
}
