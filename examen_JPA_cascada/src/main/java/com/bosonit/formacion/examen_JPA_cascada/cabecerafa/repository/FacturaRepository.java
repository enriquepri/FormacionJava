package com.bosonit.formacion.examen_JPA_cascada.cabecerafa.repository;

import com.bosonit.formacion.examen_JPA_cascada.cabecerafa.domain.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<FacturaEntity, Integer> {
}
