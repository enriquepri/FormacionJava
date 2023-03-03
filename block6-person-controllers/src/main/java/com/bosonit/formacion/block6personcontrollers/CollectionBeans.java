package com.bosonit.formacion.block6personcontrollers;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CollectionBeans {
    Persona person = null;
    List<Ciudad> listaCiudades;
}
