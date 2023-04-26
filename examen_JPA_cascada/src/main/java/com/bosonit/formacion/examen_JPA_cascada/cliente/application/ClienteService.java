package com.bosonit.formacion.examen_JPA_cascada.cliente.application;

import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;

public interface ClienteService {
    ClienteOutputDto addCliente (ClienteInputDto clienteInputDto);
}
