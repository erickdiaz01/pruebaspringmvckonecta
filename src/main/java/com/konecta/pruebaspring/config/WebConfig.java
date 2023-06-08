package com.konecta.pruebaspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.konecta.pruebaspring.mvc.converter.StringToEmpleadoDTO;
import com.konecta.pruebaspring.mvc.converter.StringToSolicitudDTO;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    StringToEmpleadoDTO stringToEmpleadoDTO;

    @Autowired
    StringToSolicitudDTO stringToSolicitudDTO;
}
