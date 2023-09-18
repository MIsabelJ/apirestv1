package com.utn.apirestv1.services;

import com.utn.apirestv1.entities.Persona;
import com.utn.apirestv1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PersonaService implements BaseService <Persona>{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> entities = personaRepository.findAll();
            return entities;
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            /*
            Cuando realizo una búsqueda tengo que tener en cuenta
            que tal vez no esté ese registro en la base de datos.
            Optional es una clase introducida en Java 8 que forma parte del
            paquete java.util. Su propósito principal es ayudar a manejar
            situaciones donde un valor puede estar presente o ausente,
            sin necesidad de recurrir a la representación de valores nulos,
            lo que puede llevar a errores de NullPointerException.
            Optional se utiliza para expresar explícitamente la posibilidad
            de que un valor sea nulo o no nulo.
            */
            Optional<Persona > entityOptional = personaRepository.findById(id);
            // Existe un método que se llama GET
            return entityOptional.get();
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepository.save(entity);
            return entity;
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            // Si existe la entidad la asigno a la variable persona y luego igualo a Save
            persona = personaRepository.save(persona);
            return persona;
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
}