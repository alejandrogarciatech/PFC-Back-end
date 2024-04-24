package com.pfc.revisiones.app.inventario.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfc.revisiones.app.inventario.EquipoValidation;
import com.pfc.revisiones.app.inventario.entities.Equipo;
import com.pfc.revisiones.app.inventario.services.EquipoServicio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoServicio servicio;

    @Autowired
    private EquipoValidation validation;

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
    public ResponseEntity<?> create(@Valid @RequestBody Equipo equipo, BindingResult result){
        validation.validate(equipo, result);
        if(result.hasFieldErrors()){
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(equipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Equipo equipo, BindingResult result, @PathVariable String id){
        validation.validate(equipo, result);
        if(result.hasFieldErrors()){
            return validation(result);
        }
        Optional<Equipo> equipoOptional = servicio.update(id, equipo);
        if (equipoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(equipoOptional.orElseThrow());  
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Optional<Equipo> equipoOptional = servicio.delete(id);
        if (equipoOptional.isPresent()) {
            return ResponseEntity.ok(equipoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err ->{
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
