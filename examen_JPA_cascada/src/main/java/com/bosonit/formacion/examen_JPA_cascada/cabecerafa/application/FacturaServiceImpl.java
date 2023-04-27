package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.application;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.controller.dto.FacturaOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain.FacturaEntity;
import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.repository.FacturaRepository;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.ClienteEntity;
import com.bosonit.formacion.examen_JPA_cascada.cliente.repository.ClienteRepository;
import com.bosonit.formacion.examen_JPA_cascada.exceptions.EntityNotFoundException;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.controller.dto.LineaInputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineafa.domain.LineaEntity;
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
        ClienteEntity c = clienteRepository.findById(facturaInputDto.getClienteid()).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra al cliente con la id: " + facturaInputDto.getClienteid())
        );

        FacturaEntity f = new FacturaEntity(facturaInputDto);
        f.setCliente(c);

        double importeTotal = 0;

        for(LineaInputDto l : lineas){
            l.setFactura(f);
            f.getLineas().add(new LineaEntity(l));
            importeTotal += l.getPrecio() * l.getCantidad();
        }

        f.setImporteFa(importeTotal);

        return facturaRepository.save(f).facturaToFacturaOutputDto();
    }

    @Override
    public List<FacturaOutputDto> getAllFacturas() {
        return facturaRepository.findAll()
                .stream()
                .map(FacturaEntity::facturaToFacturaOutputDto)
                .toList();
    }

    @Override
    public void deleteFactura(Integer idFactura) {
        FacturaEntity aBorrar = facturaRepository.findById(idFactura).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra factura con la id: " + idFactura)
        );

        facturaRepository.delete(aBorrar);
    }

    @Override
    public FacturaOutputDto addLinea(Integer idFactura, LineaInputDto lineaInputDto) {
        FacturaEntity f = facturaRepository.findById(idFactura).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra factura con la id: " + idFactura)
        );

        LineaEntity lineaGuardar = new LineaEntity(lineaInputDto);
        lineaGuardar.setFactura(f);
        f.getLineas().add(lineaGuardar);
        f.setImporteFa(f.getImporteFa() + (lineaGuardar.getCantidad() * lineaGuardar.getPrecio()));

        return facturaRepository.save(f).facturaToFacturaOutputDto();
    }
}
