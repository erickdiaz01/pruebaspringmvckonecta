package com.konecta.pruebaspring.models;

import java.time.LocalDate;


import jakarta.persistence.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "salario", nullable = false)
    private int salario;


    public Empleado(Long id) {
        this.id = id;
    }

    public Empleado(LocalDate fechaIngreso, String nombre, int salario) {
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
        this.salario = salario;
    }

    public Empleado(Long id, LocalDate fechaIngreso, String nombre, int salario) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
        this.salario = salario;
    }

    public Empleado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

}
