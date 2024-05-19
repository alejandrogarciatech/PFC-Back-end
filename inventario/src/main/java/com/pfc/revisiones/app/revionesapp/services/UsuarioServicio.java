package com.pfc.revisiones.app.revionesapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfc.revisiones.app.revionesapp.entities.Usuario;

@Service
public interface UsuarioServicio {

    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    boolean existsByUsername(String username);
}
