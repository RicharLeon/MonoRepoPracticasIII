package com.example.practicas.domain.models.employeeservice.gateway;

import com.example.practicas.infrastructure.entrypoints.dto.*;
import com.example.practicas.domain.models.employeeservice.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoConsultaDTO> findAll();
    EmpleadoConsultaDTO findById(Long id);

    List<EmpleadoConsultaByIdDTO> findByIdAll(Long id);
    Empleado save(EmpleadoPersistenciaDTO empleado);
    void delete(Long id);
    Empleado update (Empleado empleado, Long id);

    List<ProyectosEmpleadoDTO> proyectsForEmployee(Long id);

    List<EmpleadosByEquiposDTO> EquiposById(Long id);

}
