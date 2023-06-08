package com.konecta.pruebaspring.mvc.converter;

import org.springframework.stereotype.Component;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import com.konecta.pruebaspring.dto.EmpleadoDTO;
import com.konecta.pruebaspring.services.EmpleadoService;

@Component
public class StringToEmpleadoDTO implements Converter<String, EmpleadoDTO> {

    @Autowired
    EmpleadoService empleadoService;

    @Override
    public EmpleadoDTO convert(String id) {
        EmpleadoDTO empleadoDTO = empleadoService.getById(Long.valueOf(id));
        return empleadoDTO;
    }

}
