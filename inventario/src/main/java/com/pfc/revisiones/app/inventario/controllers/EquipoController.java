package com.pfc.revisiones.app.inventario.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfc.revisiones.app.inventario.entities.Equipo;
import com.pfc.revisiones.app.inventario.services.EquipoServicio;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoServicio servicio;

    @GetMapping
    public List<Equipo> list(){
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable String id){
        Optional<Equipo> equipoOptional = servicio.findById(id);
        if (equipoOptional.isPresent()) {
            return ResponseEntity.ok(equipoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Equipo> create(@RequestBody Equipo equipo){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(equipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> update(@PathVariable String id, @RequestBody Equipo equipo){
        equipo.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(equipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Optional<Equipo> equipoOptional = servicio.delete(id);
        if (equipoOptional.isPresent()) {
            return ResponseEntity.ok(equipoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
