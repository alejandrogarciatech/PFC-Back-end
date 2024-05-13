package com.pfc.revisiones.app.inventario.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity

@Table(name = "incidencias")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion; // Descripción de la incidencia
    private String estado; // Abierta, Cerrada, En proceso
    private String prioridad; // Baja, Media, Alta
    private Long idUsuario; // Quien reporta la incidencia
    private String idAlbaran; // Albarán al que se le reporta la incidencia

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @Embedded
    private Audit audit = new Audit();

    /*
     * @Column(name = "creado_en")
     * private LocalDateTime createAt;
     * 
     * @Column(name = "actualizado_en")
     * private LocalDateTime updateAt;
     */
    public Incidencia() {
    }

    public Incidencia(Long id, String descripcion, String estado, String prioridad, Long idUsuario, String idAlbaran) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.idUsuario = idUsuario;
        this.idAlbaran = idAlbaran;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAlbaran() {
        return idAlbaran;
    }

    public void setIdAlbaran(String idAlbaran) {
        this.idAlbaran = idAlbaran;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /*
     * @PrePersist
     * public void prePersist(){
     * System.out.
     * println("Evento del ciclo de vida del entity antes de persistir en la base de datos"
     * );
     * this.createAt = LocalDateTime.now();
     * }
     * 
     * @PreUpdate
     * public void preUpdate(){
     * System.out.
     * println("Evento del ciclo de vida del entity antes de actualizar en la base de datos"
     * );
     * this.updateAt = LocalDateTime.now();
     * }
     * 
     * @Override
     * public String toString() {
     * return "{createAt=" + createAt + ", descripcion=" + descripcion + ", equipo="
     * + equipo + ", estado="
     * + estado + ", id=" + id + ", idAlbaran=" + idAlbaran + ", idUsuario=" +
     * idUsuario + ", prioridad="
     * + prioridad + ", updateAt=" + updateAt + "}";
     * }
     */
    @Override
    public String toString() {
        return "{audit=" + audit.getCreateAt() + "audit=" + audit.getUpdateAt() + ", descripcion=" + descripcion + ", equipo=" + equipo + ", estado=" + estado
                + ", id=" + id + ", idAlbaran=" + idAlbaran + ", idUsuario=" + idUsuario + ", prioridad=" + prioridad
                + "}";
    }

}
