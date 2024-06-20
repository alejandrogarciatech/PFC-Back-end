package com.pfc.revisiones.app.inventario.services;

import java.util.List;
import java.util.Optional;

import com.pfc.revisiones.app.inventario.entities.Revision;

public interface RevisionServicio {

    List<Revision> findAll();

    Optional<Revision> findById(Long id);

    Optional<Revision> findByEquipoId(String equipo);

    Revision save(Revision revision);

    Optional<Revision> update(Long id, Revision revision);

    Optional<Revision> delete(Long id);
}
