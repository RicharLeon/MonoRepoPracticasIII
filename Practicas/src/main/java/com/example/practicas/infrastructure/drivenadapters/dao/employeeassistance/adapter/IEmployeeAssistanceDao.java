package com.example.practicas.infrastructure.drivenadapters.dao.employeeassistance.adapter;

import com.example.practicas.domain.models.employeeassistance.models.EmployeeAssistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IEmployeeAssistanceDao extends JpaRepository<EmployeeAssistance, Long> {

    @Query(value =
            "SELECT COUNT(id_empleado) AS total_empleados " +
                    "FROM asistenciaempleados " +
                    "WHERE fecha_asistencia BETWEEN :inicioDia AND :finDia " +
                    "GROUP BY fecha_asistencia ",
            nativeQuery = true)
    Integer countByDate(@Param("inicioDia") LocalDateTime inicioDia,
                        @Param("finDia") LocalDateTime finDia);

    @Query(value =
            "SELECT COUNT(id_empleado) AS total_empleados " +
                    "FROM asistenciaempleados " +
                    "WHERE fecha_asistencia = :day " +
                    "and id_empleado = :newIdEmployee " +
                    "GROUP BY fecha_asistencia ",
            nativeQuery = true)
    Integer getEmployeeAssitanceInSpecificDay(@Param("day") String dayChangeSchedule,
                        @Param("newIdEmployee")Long idEmployeeChangeSchedule);

    @Query(value =
            "SELECT COUNT(id_empleado) AS total_empleados " +
                    "FROM asistenciaempleados " +
                    "WHERE fecha_asistencia = :day ",
            nativeQuery = true)
    Integer countByDateOccupied(@Param("day") LocalDate day);

    @Transactional
    @Modifying
    @Query(value =
            "UPDATE asistenciaempleados " +
                    "SET estado = 'CAMBIO-HORARIO', " +
                    "id_empleado = :newIdEmployee " +
                    "WHERE id_empleado = :idEmployee " +
                    "AND fecha_asistencia = :day ",
            nativeQuery = true)
    void updateEmployeeChangeAssitance(@Param("idEmployee") Long idEmployee,
                                       @Param("day") LocalDate day);

    List<EmployeeAssistance> findByIdEmpleado(Long idEmpleado);

    @Query(value =
            "SELECT COUNT(id_empleado) AS total_empleados " +
                    "FROM asistenciaempleados " +
            "WHERE id_empleado = :idEmpleado " +
            "AND fecha_asistencia = :day",
    nativeQuery = true)
    long countByIdEmpleadoAndFechaAsistenciaBetween(
            @Param("idEmpleado") Long idEmpleado,
            @Param("day") LocalDate dayAssitance);


}
