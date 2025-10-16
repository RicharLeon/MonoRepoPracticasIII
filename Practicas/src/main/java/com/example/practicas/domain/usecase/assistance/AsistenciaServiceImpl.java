package com.example.practicas.domain.usecase.assistance;

import com.example.practicas.domain.models.assistance.gateway.IAsistenciaService;
import com.example.practicas.infrastructure.drivenadapters.dao.assistance.adapter.IAsistenciaDao;
import com.example.practicas.domain.models.assistance.model.Asistencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AsistenciaServiceImpl implements IAsistenciaService {


    private final IAsistenciaDao asistenciaDao;


    @Override
    @Transactional
    public Asistencia save(Asistencia asistenciaPersistenciaDTO) {
        //Asistencia asistenciaEntity = AsistenciaMapper.INSTANCIA.dtoPersistenciaToEntity(asistenciaPersistenciaDTO);
        return asistenciaDao.save(asistenciaPersistenciaDTO);
    }
}
