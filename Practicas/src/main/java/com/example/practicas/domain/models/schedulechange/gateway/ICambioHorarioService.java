package com.example.practicas.domain.models.schedulechange.gateway;

import com.example.practicas.infrastructure.entrypoints.dto.CambioHorarioConsultaDTO;
import com.example.practicas.domain.models.schedulechange.model.CambioHorario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICambioHorarioService {
    Page<CambioHorarioConsultaDTO> findAll(Pageable pageable);

    Page<CambioHorarioConsultaDTO> findByNameAndId(Long id, Pageable pageable);
    Optional<CambioHorarioConsultaDTO> findById(Long id);
    CambioHorario save(CambioHorario cambioHorario);
    void delete(Long id);
    CambioHorario update (CambioHorario cambioHorarioPersistenciaDTO, Long id);
}
