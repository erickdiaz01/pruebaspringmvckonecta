package com.konecta.pruebaspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo", length = 50,nullable = false)
    private String codigo;

    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;

    @Column(name = "resumen",length = 50,nullable = false)
    private String resumen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_empleado")
    private Empleado idEmpleado;

    public Solicitud() {
    }

    public Solicitud(Long id, String codigo, String descripcion, String resumen, Empleado idEmpleado) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.resumen = resumen;
        this.idEmpleado = idEmpleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
}
