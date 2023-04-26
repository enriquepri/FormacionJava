package com.bosonit.formacion.examen_JPA_cascada.cliente.application;

import com.bosonit.formacion.examen_JPA_cascada.cliente.Controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.Controller.dto.ClienteOutputDto;

public interface ClienteService {
    ClienteOutputDto addCliente (ClienteInputDto clienteInputDto);
}
