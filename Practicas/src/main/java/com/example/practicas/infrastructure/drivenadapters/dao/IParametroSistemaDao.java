package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.systemparameter.model.ParametroSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IParametroSistemaDao extends JpaRepository<ParametroSistema, Long> {

    @Query("SELECT p FROM ParametroSistema p WHERE p.nombre = :nombreParametro")
    Optional<ParametroSistema> findByNombre(@Param("nombreParametro") String nombreParametro);
}
