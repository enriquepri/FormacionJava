package com.bosonit.formacion.examen_JPA_cascada.cliente.application;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;

import java.util.List;

public interface ClienteService {
    ClienteOutputDto addCliente (ClienteInputDto clienteInputDto);
    List<ClienteOutputDto> getAllClientes();
    List<FacturaOutputDto> getFacturasFromCliente(Integer clienteId);
    void deleteCliente(Integer clienteId);
}
