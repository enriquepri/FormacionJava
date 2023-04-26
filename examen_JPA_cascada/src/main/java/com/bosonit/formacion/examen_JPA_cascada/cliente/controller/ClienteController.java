package com.bosonit.formacion.examen_JPA_cascada.cliente.controller;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.application.ClienteService;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public Iterable<ClienteOutputDto> getAllClientes(){
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Iterable<FacturaOutputDto> getFacturasCliente(
            @PathVariable Integer id
    ){
        return clienteService.getFacturasFromCliente(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(
            @PathVariable Integer id
    ){
        clienteService.deleteCliente(id);
    }
}
