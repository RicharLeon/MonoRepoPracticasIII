package com.example.practicas.domain.models.systemparameter.gateway;

import com.example.practicas.domain.models.systemparameter.model.ParametroSistema;

import java.util.Optional;

public interface IParametroSistemaService {

    Optional<ParametroSistema> findPorValor(String valor);

}
