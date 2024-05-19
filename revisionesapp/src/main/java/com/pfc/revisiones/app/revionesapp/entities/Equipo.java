package com.pfc.revisiones.app.revionesapp.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity

@Table(name = "equipos")
public class Equipo {

    @Id
    private String id;
    
    @NotEmpty(message = "{NotEmpty.equipo.nombre}")
    private String nombre;

    @NotNull(message = "{NotNull.equipo.tipoProducto}")
    private String tipoProducto;

    private String marca;
    private String modelo;
    private String nSerie;
    private double peso;
    private double dimensiones;
    @NotBlank(message = "{NotBlank.equipo.ubicacion}")
    private String ubicacion;
    private String qrcode;

    @OneToMany (mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Incidencia> incidencias;

    @Embedded
    private Audit audit = new Audit();

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
    public String getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(String tipoProducto) {
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
    public String getnSerie() {
        return nSerie;
    }
    public void setnSerie(String nSerie) {
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
    
    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String codigoBarras) {
        this.qrcode = codigoBarras;
    }

    public Equipo() {
    }

}
