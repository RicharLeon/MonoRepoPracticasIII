package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.assistance.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsistenciaDao extends JpaRepository<Asistencia, Long> {
}
