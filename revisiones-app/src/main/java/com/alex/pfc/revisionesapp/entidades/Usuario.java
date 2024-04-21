package com.alex.pfc.revisionesapp.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String puesto;
    private String correo;
    private String telefono;

    @Column(name = "f_nacimiento")
    private Date fnacimiento;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String puesto, String correo, String telefono,
            Date fnacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.correo = correo;
        this.telefono = telefono;
        this.fnacimiento = fnacimiento;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFnacimiento() {
        return fnacimiento;
    }
    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", puesto=" + puesto
                + ", correo=" + correo + ", telefono=" + telefono + ", fnacimiento=" + fnacimiento + "]";
    }

}
