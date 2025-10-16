package com.example.practicas.infrastructure.drivenadapters.mappers;

import com.example.practicas.infrastructure.entrypoints.dto.assistance.AsistenciaPersistenciaDTO;
import com.example.practicas.domain.models.assistance.model.Asistencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AsistenciaMapper {

    AsistenciaMapper INSTANCIA = Mappers.getMapper(AsistenciaMapper.class);

    Asistencia dtoPersistenciaToEntity(AsistenciaPersistenciaDTO asistencia);
}
