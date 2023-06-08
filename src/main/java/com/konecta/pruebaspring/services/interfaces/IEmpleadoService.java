package com.konecta.pruebaspring.services.interfaces;

import java.util.List;

import com.konecta.pruebaspring.dto.EmpleadoDTO;

import jakarta.validation.Valid;

public interface IEmpleadoService {
    public EmpleadoDTO save(@Valid EmpleadoDTO empleado);

    public EmpleadoDTO getById(Long id);

    public List<EmpleadoDTO> getAll();

    public void delete(Long id);
}
