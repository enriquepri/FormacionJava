package com.bosonit.formacion.examen_JPA_cascada.cliente.repository;

import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
