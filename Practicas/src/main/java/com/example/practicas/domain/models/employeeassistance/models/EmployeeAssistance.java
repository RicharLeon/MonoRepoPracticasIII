package com.example.practicas.domain.models.employeeassistance.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asistenciaempleados")
public class EmployeeAssistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long idAsistencia;
    @Column(name = "id_empleado")
    private Long idEmpleado;
    @Column(name = "fecha_asistencia")
    private LocalDateTime fechaAsistencia;
    @Column(name = "fecha_actualizacion ")
    private LocalDateTime fechaActualizacion;
    @Column(name = "estado")
    private String estadoAsistencia;

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }


}
