package com.konecta.pruebaspring.repositories;

import java.util.List;

import com.konecta.pruebaspring.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konecta.pruebaspring.models.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    Solicitud findByCodigo(String codigo);

    List<Solicitud> findByIdEmpleado(Empleado idEmpleado);
}
