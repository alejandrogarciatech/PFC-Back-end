package com.pfc.revisiones.app.inventario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfc.revisiones.app.inventario.entities.Revision;
import com.pfc.revisiones.app.inventario.repositories.RevisionRepositorio;

@Service
public class RevisionServicioJPA implements RevisionServicio{

    @Autowired
    private RevisionRepositorio repositorio;

    // LISTAR TODAS LAS REVISIONES
    @Override
    @Transactional(readOnly = true)
    public List<Revision> findAll() {
        return (List<Revision>) repositorio.findAll();
    }

    // BUSCAR REVISION POR ID
    @Override
    public Optional<Revision> findById(Long id) {
        return repositorio.findById(id);
    }

    // LISTAR LAS REVISIONES DE UN EQUIPO
    @Override
    @Transactional(readOnly = true)
    public Optional<Revision> findByEquipoId(String equipo) {
        return repositorio.findByEquipoId(equipo);
    }

    // GUARDAR REVISION
    @Override
    @Transactional
    public Revision save(Revision revision) {
        return repositorio.save(revision);
    }

    // ACTUALIZAR REVISION
    @Override
    @Transactional
    public Optional<Revision> update(Long id, Revision revision) {
        Optional<Revision> revisionOptional = repositorio.findById(id);
        if (revisionOptional.isPresent()) {
            Revision revisionDb = revisionOptional.orElseThrow();

            revisionDb.setId(revision.getId());
            revisionDb.setEquipo(revision.getEquipo());
            revisionDb.setIdUsuario(revision.getIdUsuario());
            revisionDb.setCreateAt(revision.getCreateAt());
            revisionDb.setUpdateAt(revision.getUpdateAt());

            return Optional.of(repositorio.save(revisionDb));
        }
        return revisionOptional;
    }

    // ELIMINAR REVISION
    @Override
    @Transactional
    public Optional<Revision> delete(Long id) {
        Optional<Revision> revisionOptional = repositorio.findById(id);
        if (revisionOptional.isPresent()) {
            repositorio.deleteById(id);
        }
        return revisionOptional;
    }
}
