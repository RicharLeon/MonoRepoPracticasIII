package com.example.practicas.domain.usecase.serviceschedule;

import com.example.practicas.domain.models.serviceschedule.gateway.IHorarioService;
import com.example.practicas.infrastructure.drivenadapters.dao.IHorarioDao;
import com.example.practicas.domain.models.serviceschedule.model.Horario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class HorarioServiceImpl implements IHorarioService {

    private final IHorarioDao horarioDao;
    @Override
    @Transactional
    public Horario saveHorario(Horario horario) {
        return horarioDao.save(horario);
    }
}
