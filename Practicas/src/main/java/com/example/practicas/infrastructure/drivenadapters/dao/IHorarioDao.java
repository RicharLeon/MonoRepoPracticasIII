package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.serviceschedule.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHorarioDao extends JpaRepository<Horario, Long> {
}
