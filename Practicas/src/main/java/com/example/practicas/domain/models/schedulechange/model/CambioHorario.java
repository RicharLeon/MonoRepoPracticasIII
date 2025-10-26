package com.example.practicas.domain.models.schedulechange.model;

import com.example.practicas.domain.models.employeeservice.model.Empleado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CAMBIO_HORARIO")
public class CambioHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAMBIO")
    private Long idCambioHorario;

    @Column(name = "ID_EMPLEADO_SOLICITANTE")
    private Long idEmpleadoSolicitante;

    @Column(name = "ID_EMPLEADO_APROBADOR")
    private Long idEmpleadoAprobador;

    @Column(name = "ID_EMPLEADO_CAMBIO")
    private Long idEmpleadoCambio;

    @Column(name = "DIA_CAMBIO")
    private String diaCambio;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_SOLICITUD")
    private LocalDateTime fechaSolicitud;

    @Column(name = "ACEPTADO")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO_SOLICITANTE", insertable = false, updatable = false)
    @JsonIgnore
    private Empleado empleadoSolicitante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO_APROBADOR", insertable = false, updatable = false)
    @JsonIgnore
    private Empleado empleadoAprobador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO_CAMBIO", insertable = false, updatable = false)
    @JsonIgnore
    private Empleado empleadoCambio;

    @PrePersist
    private void prePersist(){
        this.fechaSolicitud = LocalDateTime.now();
    }





}
