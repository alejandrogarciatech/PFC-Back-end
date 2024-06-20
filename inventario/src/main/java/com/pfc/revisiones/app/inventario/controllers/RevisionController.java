package com.pfc.revisiones.app.inventario.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfc.revisiones.app.inventario.entities.Revision;
import com.pfc.revisiones.app.inventario.services.RevisionServicio;

@RestController
@RequestMapping("api/revisiones")
public class RevisionController {

    @Autowired
    private RevisionServicio servicio;

    // MOSTRAR TODAS LAS REVISIONES
    @GetMapping
    public List<Revision> list() {
        return servicio.findAll();
    }

    // MOSTRAR REVISION POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> viewById(@PathVariable Long id) {
        Optional<Revision> revisionOptional = servicio.findById(id);
        if (revisionOptional.isPresent()) {
            return ResponseEntity.ok(revisionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // MOSTRAR REVISION POR EQUIPO ID
    @GetMapping("/equipo/{equipoId}")
    public ResponseEntity<?> viewByEquipoId(@PathVariable String equipoId) {
        Optional<Revision> revisionOptional = servicio.findByEquipoId(equipoId);
        if (revisionOptional.isPresent()) {
            return ResponseEntity.ok(revisionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // CREAR REVISION
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Revision revision) {
        return ResponseEntity.ok(servicio.save(revision));
    }

    // ACTUALIZAR REVISION
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Revision revision) {
        Optional<Revision> revisionOptional = servicio.update(id, revision);
        if (revisionOptional.isPresent()) {
            return ResponseEntity.ok(revisionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ELIMINAR REVISION
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Revision> revisionOptional = servicio.delete(id);
        if (revisionOptional.isPresent()) {
            return ResponseEntity.ok(revisionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
