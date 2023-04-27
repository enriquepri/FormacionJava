package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.application;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto.LineaInputDto;

import java.util.List;

public interface FacturaService {
    //FacturaOutputDto addFactura(FacturaInputDto facturaInputDto);
    FacturaOutputDto addFactura(FacturaInputDto facturaInputDto, List<LineaInputDto> lineas);
    List<FacturaOutputDto> getAllFacturas();
    void deleteFactura(Integer idFactura);
    FacturaOutputDto addLinea(Integer idFactura, LineaInputDto lineaInputDto);
}
