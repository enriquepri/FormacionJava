package com.bosonit.formacion.block7feignclient.profesor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    private int id;
    private int id_persona;
    private String comments;
    private String branch;
}
