package com.bosonit.formacion.examen_JPA_cascada;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.application.FacturaService;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class ControllerGeneral {
    @Autowired
    FacturaService facturaService;

    @GetMapping()
    public Iterable<FacturaOutputDto> getAllFacturas(){
        return facturaService.getAllFacturas();
    }

    @DeleteMapping("/{idFra}")
    public void deleteFactura(
            @PathVariable Integer idFra
    ){
        facturaService.deleteFactura(idFra);
    }
}
