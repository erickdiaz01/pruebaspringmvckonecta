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
import com.konecta.pruebaspring.mvc.forms.EmpleadoForm;
import com.konecta.pruebaspring.services.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/ver")
    public ModelAndView verEmpleados() {
        List<EmpleadoDTO> empleados = empleadoService.getAll();
        var params = new HashMap<String, Object>();
        params.put(("listaEmpleados"), empleados);
        return new ModelAndView("empleado", params);
    }

    @PostMapping(value = "/guardar")
    public ModelAndView save(EmpleadoForm empleadoForm) {
        empleadoService.save(empleadoForm.getEmpleado());
        return new ModelAndView("redirect:/empleado/ver");
    }

    @GetMapping(value = "/nuevoempleado")
    public ModelAndView nuevoEmpleado() {
        EmpleadoForm empleadoForm = new EmpleadoForm();
        empleadoForm.setEmpleado(new EmpleadoDTO());

        var params = new HashMap<String, Object>();

        params.put("empleadoForm", empleadoForm);

        return new ModelAndView("empleadoForm", params);
    }

}
