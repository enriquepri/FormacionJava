package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.application;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain.Factura;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.repository.FacturaRepository;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import com.bosonit.formacion.examen_JPA_cascada.cliente.repository.ClienteRepository;
import com.bosonit.formacion.examen_JPA_cascada.exceptions.EntityNotFoundException;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto.LineaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.domain.Linea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public FacturaOutputDto addFactura(FacturaInputDto facturaInputDto, List<LineaInputDto> lineas) {
        Cliente c = clienteRepository.findById(facturaInputDto.getClienteid()).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra al cliente con la id: " + facturaInputDto.getClienteid())
        );

        Factura f = new Factura(facturaInputDto);
        f.setCliente(c);

        double importeTotal = 0;

        for(LineaInputDto l : lineas){
            l.setFactura(f);
            f.getLineas().add(new Linea(l));
            importeTotal += l.getPrecio() * l.getCantidad();
        }

        f.setImporteFa(importeTotal);

        return facturaRepository.save(f).facturaToFacturaOutputDto();
    }

    @Override
    public List<FacturaOutputDto> getAllFacturas() {
        return facturaRepository.findAll()
                .stream()
                .map(Factura::facturaToFacturaOutputDto)
                .toList();
    }

    @Override
    public void deleteFactura(Integer idFactura) {
        Factura aBorrar = facturaRepository.findById(idFactura).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra factura con la id: " + idFactura)
        );

        facturaRepository.delete(aBorrar);
    }
}
