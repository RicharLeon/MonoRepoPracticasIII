package com.example.practicas.infrastructure.entrypoints.dto.schedulechange;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Null;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CambioHorarioPersistenciaDTO {

    private Long idCambioHorario;
    private Long idEmpleadoSolicitante;
    private Long idEmpleadoAprobador;
    private Long idEmpleadoCambio;
    @Null
    private boolean estado;
}
