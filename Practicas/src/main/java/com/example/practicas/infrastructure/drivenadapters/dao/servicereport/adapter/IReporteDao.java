package com.example.practicas.infrastructure.drivenadapters.dao.servicereport.adapter;

import com.example.practicas.infrastructure.entrypoints.dto.servicereport.ReporteConsultaDTO;
import com.example.practicas.domain.models.servicereport.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReporteDao extends JpaRepository<Reporte, Long> {
    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.servicereport.ReporteConsultaDTO(r.idEmpleado, ie.nombre, are.nombre, py.Nombre, r.asistencia, r.fechaAsistencia) from Asistencia r " +
            "inner join r.empleado ie " +
            "inner join ie.area are " +
            "inner join ie.proyecto py "
    )
    List<ReporteConsultaDTO> reporteFindEmpleadosDTO();

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.servicereport.ReporteConsultaDTO(r.idEmpleado, ie.nombre, are.nombre, py.Nombre, r.asistencia, r.fechaAsistencia) from Asistencia r " +
            "inner join r.empleado ie " +
            "inner join ie.area are " +
            "inner join ie.proyecto py " +
            "where ie.idEmpleado = ?1"
    )
    List<ReporteConsultaDTO> reporteFindEmpleadosForIdDTO(Long id);

}
