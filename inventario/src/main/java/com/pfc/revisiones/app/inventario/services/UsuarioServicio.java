package com.pfc.revisiones.app.inventario.services;

import java.util.List;

import com.pfc.revisiones.app.inventario.entities.Usuario;

public interface UsuarioServicio {

    List<Usuario> findAll();

    Usuario save(Usuario usuario);
}
