package com.example.practicas.domain.models.employeeassistance.gateway;

import com.example.practicas.domain.models.employeeassistance.models.EmployeeAssistance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IEmployeeAssistanceService {
    List<EmployeeAssistance> employeeAssitanceAll(Long employeeId);

    int availablePositions(LocalDate from);

    EmployeeAssistance saveAsssistance(EmployeeAssistance employeeAssistance);
}
