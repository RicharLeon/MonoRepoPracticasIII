package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.employeeservice.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAreaDao extends JpaRepository<Area, Long> {

}
