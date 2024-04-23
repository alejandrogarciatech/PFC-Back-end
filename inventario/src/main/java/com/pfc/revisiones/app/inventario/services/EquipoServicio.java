package com.pfc.revisiones.app.inventario.services;

import java.util.List;
import java.util.Optional;

import com.pfc.revisiones.app.inventario.entities.Equipo;

public interface EquipoServicio {

    List<Equipo> findAll();
    Optional<Equipo> findById(String id);
    Equipo save(Equipo equipo);
    Optional<Equipo> delete(String id);

}
