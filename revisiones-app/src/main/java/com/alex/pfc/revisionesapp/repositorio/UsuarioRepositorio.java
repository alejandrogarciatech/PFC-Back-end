package com.alex.pfc.revisionesapp.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alex.pfc.revisionesapp.entidades.Usuario;
//import java.util.List;


public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

    List<Usuario> findByPuestoAndNombre(String puesto, String nombre);
/*
    List<Usuario> findByPuesto(String puesto, String string);

    @Query("select u from Usuario u where u.puesto=?1 and u.nombre=?2")
    List<Usuario> buscarByPuesto(String puesto, String nombre);
    */

    //List<Object[]> obtenerDatosUsuarioByPuesto(String puesto);

    @Query("select u from Usuario u where u.id=?1")
    Optional<Usuario> findOne(Long id);

    @Query("select u from Usuario u where u.nombre=?1")
    Optional<Usuario> findOneNombre(String nombre);

    @Query("select u from Usuario u where u.nombre like %?1")
    Optional<Usuario> findOneLikeNombre(String nombre);

    Optional<Usuario> findByNombreContaining(String nombre);

    @Query("select u.nombre from Usuario u where u.id=?1")
    String getNombreById(Long id);

    
    @Query("select concat (u.nombre, ' ', u.apellido) as nombreCompleto from Usuario u where u.id=?1")
    String getNombreCompletoById(Long id);
} 
