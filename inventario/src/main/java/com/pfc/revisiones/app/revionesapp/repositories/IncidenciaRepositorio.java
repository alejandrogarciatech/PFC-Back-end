package com.pfc.revisiones.app.revionesapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pfc.revisiones.app.revionesapp.entities.Incidencia;

public interface IncidenciaRepositorio extends CrudRepository<Incidencia, Long>{

    Optional<Incidencia> findByEquipoId(String equipo);

}
