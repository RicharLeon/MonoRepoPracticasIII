package com.example.practicas.infrastructure.drivenadapters.mappers;

import com.example.practicas.infrastructure.entrypoints.dto.EmpleadoPersistenciaDTO;
import com.example.practicas.domain.models.employeeservice.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    EmpleadoMapper INSTANCIA = Mappers.getMapper(EmpleadoMapper.class);

    Empleado dtoPersistenciaToEntity(EmpleadoPersistenciaDTO empleado);

}
