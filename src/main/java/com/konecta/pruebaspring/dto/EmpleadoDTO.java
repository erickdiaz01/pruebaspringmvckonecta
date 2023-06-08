package com.konecta.pruebaspring.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmpleadoDTO {
    private Long id;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Long id) {
        this.id = id;
    }

    @NotBlank
    private String nombre;

    private LocalDate fechaIngreso;

    @Min(500000)
    private int salario;

    public EmpleadoDTO(Long id, @NotBlank String nombre, LocalDate fechaIngreso, @Min(500000) int salario) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
    }

    public EmpleadoDTO(@NotBlank String nombre, LocalDate fechaIngreso, @Min(500000) int salario) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
