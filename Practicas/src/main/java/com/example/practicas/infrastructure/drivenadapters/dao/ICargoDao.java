package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.employeeservice.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICargoDao extends JpaRepository<Cargo, Long> {
}
