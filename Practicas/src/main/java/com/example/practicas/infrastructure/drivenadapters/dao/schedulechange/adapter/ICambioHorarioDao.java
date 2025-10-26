package com.example.practicas.infrastructure.drivenadapters.dao.schedulechange.adapter;

import com.example.practicas.infrastructure.entrypoints.dto.schedulechange.CambioHorarioConsultaDTO;
import com.example.practicas.infrastructure.entrypoints.dto.schedulechange.CambioHorarioPersistenciaDTO;
import com.example.practicas.domain.models.schedulechange.model.CambioHorario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICambioHorarioDao extends JpaRepository<CambioHorario, Long> {

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.schedulechange.CambioHorarioPersistenciaDTO(c.idCambioHorario, es.idEmpleado, ea.idEmpleado, ec.idEmpleado, c.estado) from CambioHorario c " +
            "inner join c.empleadoAprobador ea " +
            "inner join c.empleadoCambio ec " +
            "inner join c.empleadoSolicitante es "
    )
    List<CambioHorarioPersistenciaDTO> findCambiodeHorario();

    //este es el que hay que cambiar
    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.schedulechange.CambioHorarioConsultaDTO(c.idCambioHorario, es.idEmpleado, es.nombre, ea.idEmpleado, ea.nombre, ec.idEmpleado, ec.nombre, c.estado, c.descripcion, c.fechaSolicitud, c.diaCambio) " +
            "from CambioHorario c " +
            "left join c.empleadoAprobador ea " +
            "left join c.empleadoCambio ec " +
            "left join c.empleadoSolicitante es " +
            "where c.idCambioHorario = ?1"
    )
    Optional<CambioHorarioConsultaDTO> findCambiodeHorarioPorId(Long id);

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.schedulechange.CambioHorarioConsultaDTO(c.idCambioHorario, es.idEmpleado, es.nombre, ea.idEmpleado, ea.nombre, ec.idEmpleado, ec.nombre, c.estado, c.descripcion, c.fechaSolicitud, c.diaCambio) " +
            "from CambioHorario c " +
            "left join c.empleadoAprobador ea " +
            "left join c.empleadoCambio ec " +
            "left join c.empleadoSolicitante es " +
            " order by c.fechaSolicitud desc")
    Page<CambioHorarioConsultaDTO> findCambiodeHorarioForNamesEmployee(Pageable pageable);

    @Query("select new com.example.practicas.infrastructure.entrypoints.dto.schedulechange.CambioHorarioConsultaDTO(c.idCambioHorario, es.idEmpleado, es.nombre, ea.idEmpleado, ea.nombre, ec.idEmpleado, ec.nombre, c.estado, c.descripcion, c.fechaSolicitud, c.diaCambio) " +
            "from CambioHorario c " +
            "left join c.empleadoAprobador ea " +
            "left join c.empleadoCambio ec " +
            "left join c.empleadoSolicitante es " +
            "where es.idEmpleado = ?1" +
            " order by c.fechaSolicitud desc"
    )
    Page<CambioHorarioConsultaDTO> findCambiodeHorarioForNamesEmployeeForId(Long id, Pageable pageable);


}
