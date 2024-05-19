package com.pfc.revisiones.app.revionesapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pfc.revisiones.app.revionesapp.entities.Rol;

public interface RolRepositorio extends CrudRepository<Rol, Long>{

    Optional<Rol> findByNombre(String nombre);
}
