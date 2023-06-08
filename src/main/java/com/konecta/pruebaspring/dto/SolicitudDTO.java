package com.konecta.pruebaspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SolicitudDTO {
    private Long id;

    public SolicitudDTO() {
    }

    public SolicitudDTO(Long id, @NotBlank String codigo, @NotBlank String descripcion, @NotBlank String resumen,
            @NotNull EmpleadoDTO empleado) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.resumen = resumen;
        this.empleado = empleado;
    }

    @NotBlank
    private String codigo;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String resumen;

    @NotNull
    private EmpleadoDTO empleado;

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

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public SolicitudDTO(@NotBlank String codigo, @NotBlank String descripcion, @NotBlank String resumen,
            Long idEmpleado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.resumen = resumen;
        this.empleado = new EmpleadoDTO(idEmpleado);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

}
