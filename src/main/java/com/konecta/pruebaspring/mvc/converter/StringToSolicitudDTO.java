package com.konecta.pruebaspring.mvc.converter;

import org.springframework.stereotype.Component;

import com.konecta.pruebaspring.dto.SolicitudDTO;
import com.konecta.pruebaspring.services.SolicitudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

@Component
public class StringToSolicitudDTO implements Converter<String, SolicitudDTO> {
    @Autowired
    SolicitudService solicitudService;

    @Override
    public SolicitudDTO convert(String id) {
        SolicitudDTO solicitudDTO = solicitudService.getById(Long.valueOf(id));
        return solicitudDTO;
    }

}
