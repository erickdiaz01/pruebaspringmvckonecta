package com.konecta.pruebaspring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.konecta.pruebaspring.dto.EmpleadoDTO;
import com.konecta.pruebaspring.models.Empleado;
import com.konecta.pruebaspring.repositories.EmpleadoRepository;
import com.konecta.pruebaspring.services.interfaces.IEmpleadoService;

import jakarta.validation.Valid;

@Service
@Validated
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmpleadoDTO save(@Valid EmpleadoDTO empleado) {
        Empleado empleadoEntity = modelMapper.map(empleado, Empleado.class);

        empleadoEntity = empleadoRepository.save(empleadoEntity);
        return modelMapper.map(empleadoEntity, EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO getById(Long id) {
        Empleado empleadoEntity = empleadoRepository.getReferenceById(id);
        EmpleadoDTO empleadoDTO = modelMapper.map(empleadoEntity, EmpleadoDTO.class);
        return empleadoDTO;
    }

    @Override
    public List<EmpleadoDTO> getAll() {
        List<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTOs = empleados.stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDTO.class)).collect(Collectors.toList());
        return empleadosDTOs;
    }

    @Override
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }

}
