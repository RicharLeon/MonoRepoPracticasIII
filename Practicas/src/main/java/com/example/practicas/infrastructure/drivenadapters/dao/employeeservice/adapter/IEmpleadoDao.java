package com.example.practicas.infrastructure.drivenadapters.dao.employeeservice.adapter;

import com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadoConsultaByIdDTO;
import com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadoConsultaDTO;
import com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadosByEquiposDTO;
import com.example.practicas.infrastructure.entrypoints.dto.employeeservice.ProyectosEmpleadoDTO;
import com.example.practicas.domain.models.employeeservice.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadoConsultaDTO(e.idEmpleado, e.nombre, e.apellido, td.nombre, e.documento,  tc.nombre, tco.nombre, ta.nombre, tp.Nombre) from Empleado e " +
            "inner join e.tipoDocumento td " +
            "inner join e.cargo tc " +
            "inner join e.tipoContrato tco " +
            "inner join e.area ta " +
            "inner join e.proyecto tp "
    )
    List<EmpleadoConsultaDTO> findEmpleados();

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadoConsultaDTO(e.idEmpleado, e.nombre, e.apellido, td.nombre, e.documento, tc.nombre, tco.nombre, ta.nombre, tp.Nombre) from Empleado e " +
            "inner join e.tipoDocumento td " +
            "inner join e.cargo tc " +
            "inner join e.tipoContrato tco " +
            "inner join e.area ta " +
            "inner join e.proyecto tp " +
            "where e.idEmpleado = ?1"
    )
    Optional<EmpleadoConsultaDTO> findEmpleadosForId(Long id);

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadoConsultaByIdDTO(" +
            "e.idEmpleado, e.nombre, e.apellido, td.nombre, e.documento, tc.nombre, tco.nombre, ta.nombre, " +
            "p.Nombre, p.descripcionProyecto) " +
            "from ProyectosPorEmpleado ppe " +
            "inner join ppe.empleado e " +
            "inner join e.tipoDocumento td " +
            "inner join e.cargo tc " +
            "inner join e.tipoContrato tco " +
            "inner join e.area ta " +
            "inner join ppe.proyecto p " +
            "where e.idEmpleado = ?1")
    List<EmpleadoConsultaByIdDTO> findEmpleadosForIdAllData(Long id);

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.employeeservice.ProyectosEmpleadoDTO(p.Nombre, p.descripcionProyecto) " +
            "from ProyectosPorEmpleado ppe " +
            "inner join ppe.empleado e " +
            "inner join  ppe.proyecto p " +
            "where e.idEmpleado = ?1 and p.estado = 'En Curso' ")
    List<ProyectosEmpleadoDTO> findProyectsForEmployee(Long id);

    @Query("SELECT new com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadosByEquiposDTO(e.idEmpleado, e.nombre, e.apellido, e.idTipoDocumento, e.documento, e.idCargo, e.idTipoContrato, e.idArea, e.idProyecto, e.idEquipos) FROM Empleado e WHERE e.idEquipos = (SELECT e2.idEquipos FROM Empleado e2 WHERE e2.idEmpleado = ?1)")
    List<EmpleadosByEquiposDTO> findEmpleadosByEquipoId(Long id);



}
