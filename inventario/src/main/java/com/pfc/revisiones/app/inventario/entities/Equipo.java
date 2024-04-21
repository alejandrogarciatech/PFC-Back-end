package com.pfc.revisiones.app.inventario.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    private String nombre;
    private Long tipoProducto;
    private String marca;
    private String modelo;
    private Long nSerie;
    private double peso;
    private double dimensiones;
    private String ubicacion;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(Long tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Long getnSerie() {
        return nSerie;
    }
    public void setnSerie(Long nSerie) {
        this.nSerie = nSerie;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getDimensiones() {
        return dimensiones;
    }
    public void setDimensiones(double dimensiones) {
        this.dimensiones = dimensiones;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }



}
