package com.pfc.revisiones.app.inventario.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfc.revisiones.app.inventario.entities.Usuario;

@Service
public interface UsuarioServicio {

    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    boolean existsByUsername(String username);
}
