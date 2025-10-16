package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.employeeservice.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoDocumentoDao extends JpaRepository<TipoDocumento, Long> {
}
