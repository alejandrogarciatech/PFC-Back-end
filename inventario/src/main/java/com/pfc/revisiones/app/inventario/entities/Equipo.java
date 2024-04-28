package com.pfc.revisiones.app.inventario.entities;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;

@Entity

@Table(name = "equipos")
public class Equipo {

    @Id
    private String id;
    
    @NotEmpty(message = "{NotEmpty.equipo.nombre}")
    private String nombre;

    @Min(value = 500, message = "{Min.equipo.tipoProducto}")
    @NotNull(message = "{NotNull.equipo.tipoProducto}")
    private Long tipoProducto;

    private String marca;
    private String modelo;
    private Long nSerie;
    private double peso;
    private double dimensiones;
    private String qrcode;

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String codigoBarras) {
        this.qrcode = codigoBarras;
    }
    
    @NotBlank(message = "{NotBlank.equipo.ubicacion}")
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
