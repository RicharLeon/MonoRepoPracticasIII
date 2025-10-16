package com.example.practicas.infrastructure.drivenadapters.dao;

import com.example.practicas.domain.models.employeeservice.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProyectoDao extends JpaRepository<Proyecto, Long> {


}
