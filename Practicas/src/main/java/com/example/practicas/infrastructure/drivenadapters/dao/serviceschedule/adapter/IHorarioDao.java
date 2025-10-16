package com.example.practicas.infrastructure.drivenadapters.dao.serviceschedule.adapter;

import com.example.practicas.domain.models.serviceschedule.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHorarioDao extends JpaRepository<Horario, Long> {
}
