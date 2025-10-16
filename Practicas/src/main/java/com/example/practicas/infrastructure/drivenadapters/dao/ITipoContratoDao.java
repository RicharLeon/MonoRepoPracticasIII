package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.employeeservice.model.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoContratoDao extends JpaRepository<TipoContrato, Long> {
}
