package com.pfc.revisiones.app.inventario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfc.revisiones.app.inventario.entities.Equipo;
import com.pfc.revisiones.app.inventario.repositories.EquipoRepositorio;

@Service
public class EquipoServicioJPA implements EquipoServicio{


    @Autowired
    private EquipoRepositorio repositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Equipo> findAll() {
        return (List<Equipo>) repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Equipo> findById(String id) {
        return repositorio.findById(id);
    }

    @Override
    @Transactional
    public Equipo save(Equipo equipo) {
        return repositorio.save(equipo);
    }

    @Override
    @Transactional
    public Optional<Equipo> delete(String id) {
        Optional<Equipo> equipoOptional = repositorio.findById(id);
        equipoOptional.ifPresent(equipoDb -> {
            repositorio.delete(equipoDb);
        });
        return equipoOptional;
    }

}
