package com.alex.pfc.revisionesapp.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.alex.pfc.revisionesapp.entidades.Equipo;

@RepositoryRestResource(path = "equipos")
public interface EquipoRepositorio extends CrudRepository<Equipo, String> {

}
