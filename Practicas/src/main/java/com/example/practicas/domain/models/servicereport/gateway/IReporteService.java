package com.example.practicas.domain.models.servicereport.gateway;

import com.example.practicas.infrastructure.entrypoints.dto.ReporteConsultaDTO;
import com.example.practicas.domain.models.servicereport.model.Reporte;

import java.io.IOException;
import java.util.List;

public interface IReporteService {
    Reporte save(Reporte reporte);
    byte[] reportePorUnEmpleado(Long idEmpleado) throws IOException;
    byte[] reporteTodosLosEmpleados() throws IOException;

    List<ReporteConsultaDTO> allReports();

    byte[] generarReporteJasper(List<ReporteConsultaDTO> reporte);
    byte[] generarReporteJasperPorIdEmployee(Long empleadoID);

}
