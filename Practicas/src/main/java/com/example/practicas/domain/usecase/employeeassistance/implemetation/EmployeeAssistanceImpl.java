package com.example.practicas.domain.usecase.employeeassistance.implemetation;

import com.example.practicas.domain.models.employeeassistance.gateway.IEmployeeAssistanceService;
import com.example.practicas.domain.models.employeeassistance.models.EmployeeAssistance;
import com.example.practicas.domain.models.shared.exceptions.NoContentException;
import com.example.practicas.domain.models.shared.values.Constantes;
import com.example.practicas.infrastructure.drivenadapters.dao.employeeassistance.adapter.IEmployeeAssistanceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeAssistanceImpl implements IEmployeeAssistanceService {

    private final IEmployeeAssistanceDao employeeAssistanceDao;

    @Override
    public List<EmployeeAssistance> employeeAssitanceAll(Long employeeId) {
        return employeeAssistanceDao.findByIdEmpleado(employeeId);
    }

    @Override
    public int availablePositions(LocalDate from) {
        var occupied = employeeAssistanceDao.countByDateOccupied(from);
        if (occupied == null || occupied.equals(0) ) {
            occupied = 0;
        }
        var available = Constantes.DISPONIBLES_PUESTOS - occupied;
        return Math.max(available, 0);
    }

    @Override
    public EmployeeAssistance saveAsssistance(EmployeeAssistance employeeAssistance) {
        var dayOfAssitance = employeeAssistance.getFechaAsistencia().toLocalDate();
        var validateOccupied = valdiatePositionsOccupied(dayOfAssitance);
        if (validateOccupied) {
            validateUserMoreThanOneAttendance(employeeAssistance);
            return employeeAssistanceDao.save(employeeAssistance) ;
        }
        throw new NoContentException("LA CANTIDA DE PUESTO OCUPADOS ES MAYOR A LA PERMITIDA");
    }

    public boolean valdiatePositionsOccupied(LocalDate date) {
        var positionsOcupied = employeeAssistanceDao.countByDateOccupied(date);
        if (positionsOcupied == null || positionsOcupied.equals(0) ) {
            positionsOcupied = 0;
        }
        if(positionsOcupied < Constantes.DISPONIBLES_PUESTOS) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public EmployeeAssistance validateUserMoreThanOneAttendance(EmployeeAssistance employeeAssistance) {
        var dayOfAssitance = employeeAssistance.getFechaAsistencia().toLocalDate();
        var positionsOcupied = employeeAssistanceDao.countByIdEmpleadoAndFechaAsistenciaBetween(
                employeeAssistance.getIdEmpleado(),
                dayOfAssitance
        );
        if (positionsOcupied >= Constantes.NUMBER_ONE) {
            throw new NoContentException("EL USUARIO YA TIENE UN CUPO ASIGNADO");
        }
        return employeeAssistance;

    }
}
