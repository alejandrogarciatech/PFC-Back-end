package com.pfc.revisiones.app.inventario.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pfc.revisiones.app.inventario.entities.Revision;

public interface RevisionRepositorio extends CrudRepository<Revision, Long>{

    Optional<Revision> findByEquipoId(String equipo);
}
