package com.example.practicas.infrastructure.drivenadapters.mappers;

import com.example.practicas.domain.models.assistance.model.Asistencia;
import com.example.practicas.infrastructure.entrypoints.dto.assistance.AsistenciaPersistenciaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-22T23:24:14-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class AsistenciaMapperImpl implements AsistenciaMapper {

    @Override
    public Asistencia dtoPersistenciaToEntity(AsistenciaPersistenciaDTO asistencia) {
        if ( asistencia == null ) {
            return null;
        }

        Asistencia asistencia1 = new Asistencia();

        asistencia1.setIdEmpleado( asistencia.getIdEmpleado() );
        asistencia1.setAsistencia( asistencia.isAsistencia() );
        asistencia1.setIdCodigoQR( asistencia.getIdCodigoQR() );
        asistencia1.setFechaAsistencia( asistencia.getFechaAsistencia() );

        return asistencia1;
    }
}
