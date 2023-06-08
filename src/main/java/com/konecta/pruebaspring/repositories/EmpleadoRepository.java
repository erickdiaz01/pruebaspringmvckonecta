package com.konecta.pruebaspring.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konecta.pruebaspring.models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findByNombre(String nombre);

    List<Empleado> findBySalario(int salario);

    List<Empleado> findByFechaIngreso(LocalDate fechaIngreso);
}
