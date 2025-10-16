package com.example.practicas.domain.usecase.systemparameter;

import com.example.practicas.domain.models.systemparameter.gateway.IParametroSistemaService;
import com.example.practicas.infrastructure.drivenadapters.dao.systemparameter.adapter.IParametroSistemaDao;
import com.example.practicas.domain.models.systemparameter.model.ParametroSistema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ParametroSistemaServiceImpl implements IParametroSistemaService {

    private final IParametroSistemaDao parametroDao;
    @Override
    public Optional<ParametroSistema> findPorValor(String valor) {
        return parametroDao.findByNombre(valor);
    }
}
