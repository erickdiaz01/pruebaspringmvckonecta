package com.konecta.pruebaspring.services.interfaces;

import java.util.List;

import com.konecta.pruebaspring.dto.SolicitudDTO;

import jakarta.validation.Valid;

public interface ISolicitudService {

    public SolicitudDTO save(@Valid SolicitudDTO solicitud);

    public SolicitudDTO getById(Long id);

    public SolicitudDTO getByCodigo(String codigo);

    public List<SolicitudDTO> getAll();

    public void delete(Long id);

    public void deleteByCodigo(String codigo);
}
