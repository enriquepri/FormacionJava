package com.bosonit.formacion.block11uploaddownloadfiles.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.io.File;

/*
CLASE NO USADA AL FINAL
*/

@Data
@Builder
public class FicheroOutputDto {
    int id;
    String tipo;
    String nombre;
    String fechaSubida;
    File archivo;
}
