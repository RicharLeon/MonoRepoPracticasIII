package com.example.practicas.infrastructure.entrypoints.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProyectosEmpleadoDTO {
    private String nombre;
    private String descripcionProyecto;
}
