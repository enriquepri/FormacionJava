package com.bosonit.formacion.block6personcontrollers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    String nombre;
    String ciudad;
    int edad;

    public void persona(String nombre, String ciudad, int edad){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }
}
