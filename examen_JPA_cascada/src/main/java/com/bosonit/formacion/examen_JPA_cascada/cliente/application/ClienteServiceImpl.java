package com.bosonit.formacion.examen_JPA_cascada.cliente.application;

import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import com.bosonit.formacion.examen_JPA_cascada.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public ClienteOutputDto addCliente(ClienteInputDto clienteInputDto) {
        return clienteRepository.save(new Cliente(clienteInputDto))
                .clienteToClienteOutputDto();
    }
}
