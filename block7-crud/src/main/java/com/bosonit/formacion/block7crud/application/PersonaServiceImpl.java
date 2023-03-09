package com.bosonit.formacion.block7crud.application;

import com.bosonit.formacion.block7crud.domain.Persona;
import com.bosonit.formacion.block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona addPersona(Persona p) {
        return personaRepository.save(p);
    }

    @Override
    public Persona updatePersona(Persona p) {
        personaRepository.findById(p.getId()).orElseThrow();
        return personaRepository.save(p);
    }

    @Override
    public void deletePersonaById(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }

    @Override
    public Persona getPersonaById(int id) {
        return personaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Persona> getAllByName(String nombre) {
        return personaRepository.findAll().stream()
                .filter(persona -> persona.getNombre().equals(nombre))
                .toList();
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }
}
