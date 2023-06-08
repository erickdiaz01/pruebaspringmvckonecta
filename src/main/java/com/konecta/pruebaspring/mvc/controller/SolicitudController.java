package com.konecta.pruebaspring.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.konecta.pruebaspring.dto.EmpleadoDTO;
import com.konecta.pruebaspring.dto.SolicitudDTO;
import com.konecta.pruebaspring.mvc.forms.SolicitudForm;
import com.konecta.pruebaspring.services.EmpleadoService;
import com.konecta.pruebaspring.services.SolicitudService;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {

    @Autowired
    SolicitudService solicitudService;
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/ver")
    public ModelAndView verSolicitudes() {
        List<SolicitudDTO> solicitudes = solicitudService.getAll();
        var params = new HashMap<String, Object>();
        params.put("listaSolicitudes", solicitudes);
        return new ModelAndView("solicitud", params);
    }

    @PostMapping(value = "/guardar")
    public ModelAndView nuevaSolicitud(SolicitudForm solicitudForm) {
        EmpleadoDTO empleado = empleadoService.getById(solicitudForm.getSolicitud().getEmpleado().getId());
        solicitudForm.getSolicitud().setEmpleado(empleado);
        solicitudService.save(solicitudForm.getSolicitud());
        return new ModelAndView("redirect:/solicitud/ver");
    }

    @GetMapping(value = "/nuevasolicitud")
    public ModelAndView nuevaSolicitud() {
        SolicitudForm solicitudForm = new SolicitudForm();
        solicitudForm.setSolicitud(new SolicitudDTO());

        var params = new HashMap<String, Object>();

        params.put("solicitudForm", solicitudForm);

        return new ModelAndView("solicitudForm", params);
    }
}
