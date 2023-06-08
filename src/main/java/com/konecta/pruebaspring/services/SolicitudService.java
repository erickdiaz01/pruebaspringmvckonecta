package com.konecta.pruebaspring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.konecta.pruebaspring.dto.SolicitudDTO;
import com.konecta.pruebaspring.models.Solicitud;
import com.konecta.pruebaspring.repositories.SolicitudRepository;
import com.konecta.pruebaspring.services.exception.CasoDeNegocioException;
import com.konecta.pruebaspring.services.interfaces.ISolicitudService;

import jakarta.validation.Valid;

@Service
@Validated
public class SolicitudService implements ISolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SolicitudDTO save(@Valid SolicitudDTO solicitud) {
        Solicitud solicitudEntity = modelMapper.map(solicitud, Solicitud.class);
        solicitudEntity = solicitudRepository.save(solicitudEntity);
        return modelMapper.map(solicitudEntity, SolicitudDTO.class);
    }

    @Override
    public SolicitudDTO getById(Long id) {
        Solicitud solicitudEntity = solicitudRepository.getReferenceById(id);
        SolicitudDTO solicitudDTO = modelMapper.map(solicitudEntity, SolicitudDTO.class);
        return solicitudDTO;
    }

    @Override
    public SolicitudDTO getByCodigo(String codigo) {
        Solicitud solicitudEntity = solicitudRepository.findByCodigo(codigo);
        SolicitudDTO solicitudDTO = modelMapper.map(solicitudEntity, SolicitudDTO.class);
        return solicitudDTO;
    }

    @Override
    public List<SolicitudDTO> getAll() {
        List<Solicitud> solicitudes = solicitudRepository.findAll();
        List<SolicitudDTO> solicitudesDTOs = solicitudes.stream()
                .map(solicitud -> modelMapper.map(solicitud, SolicitudDTO.class))
                .collect(Collectors.toList());
        return solicitudesDTOs;
    }

    @Override
    public void delete(Long id) {
        solicitudRepository.deleteById(id);
    }

    @Override
    public void deleteByCodigo(String codigo) {
        try {
            Solicitud solicitudEntity = solicitudRepository.findByCodigo(codigo);
            solicitudRepository.delete(solicitudEntity);

        } catch (Exception e) {
            throw new CasoDeNegocioException("No se encontro la solicitud a eliminar", e);
        }
    }

}
