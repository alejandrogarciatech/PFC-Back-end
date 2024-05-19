package com.pfc.revisiones.app.revionesapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pfc.revisiones.app.revionesapp.entities.Equipo;

public interface EquipoRepositorio extends CrudRepository<Equipo, String> {

    Optional<Equipo> findByNombre(String nombre);

    Optional<Equipo> findByTipoProducto(String tipoProducto);

}
