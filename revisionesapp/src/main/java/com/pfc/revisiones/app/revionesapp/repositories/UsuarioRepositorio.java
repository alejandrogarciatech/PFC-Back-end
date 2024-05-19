package com.pfc.revisiones.app.revionesapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfc.revisiones.app.revionesapp.entities.Usuario;
@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

    boolean existsByUsername(String username);

    Optional<Usuario> findByUsername(String username);
}
