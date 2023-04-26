package com.bosonit.formacion.examen_JPA_cascada.cliente.application;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain.Factura;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import com.bosonit.formacion.examen_JPA_cascada.cliente.repository.ClienteRepository;
import com.bosonit.formacion.examen_JPA_cascada.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public ClienteOutputDto addCliente(ClienteInputDto clienteInputDto) {
        return clienteRepository.save(new Cliente(clienteInputDto))
                .clienteToClienteOutputDto();
    }

    @Override
    public List<ClienteOutputDto> getAllClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(Cliente::clienteToClienteOutputDto)
                .toList();
    }

    @Override
    public List<FacturaOutputDto> getFacturasFromCliente(Integer clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra al cliente")
        );

        return cliente.getFacturas()
                .stream()
                .map(Factura::facturaToFacturaOutputDto)
                .toList();
    }

    @Override
    public void deleteCliente(Integer clienteId) {
        Cliente aBorrar = clienteRepository.findById(clienteId).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra al cliente")
        );

        clienteRepository.delete(aBorrar);
    }
}
