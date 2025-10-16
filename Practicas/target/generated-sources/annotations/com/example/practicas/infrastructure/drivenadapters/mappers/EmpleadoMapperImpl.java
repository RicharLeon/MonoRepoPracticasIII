package com.example.practicas.infrastructure.drivenadapters.mappers;

import com.example.practicas.domain.models.employeeservice.model.Empleado;
import com.example.practicas.infrastructure.entrypoints.dto.employeeservice.EmpleadoPersistenciaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-16T00:08:00-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class EmpleadoMapperImpl implements EmpleadoMapper {

    @Override
    public Empleado dtoPersistenciaToEntity(EmpleadoPersistenciaDTO empleado) {
        if ( empleado == null ) {
            return null;
        }

        Empleado empleado1 = new Empleado();

        empleado1.setNombre( empleado.getNombre() );
        empleado1.setApellido( empleado.getApellido() );
        empleado1.setDocumento( empleado.getDocumento() );
        empleado1.setIdTipoDocumento( empleado.getIdTipoDocumento() );
        empleado1.setIdCargo( empleado.getIdCargo() );
        empleado1.setIdTipoContrato( empleado.getIdTipoContrato() );
        empleado1.setIdArea( empleado.getIdArea() );
        empleado1.setIdProyecto( empleado.getIdProyecto() );

        return empleado1;
    }
}
