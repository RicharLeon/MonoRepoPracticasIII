package com.example.practicas.domain.models.shared.qrcodes.gateway;

import com.example.practicas.infrastructure.entrypoints.dto.CodigosQrConsultaDTO;
import com.example.practicas.domain.models.shared.qrcodes.model.CodigosQr;

import java.util.List;

public interface ICodigosQrService {


    List<CodigosQrConsultaDTO> mostrarQrPorEmpleado(Long id);

    CodigosQrConsultaDTO mostrarQrPorEmpleadoActivo(Long id);

    CodigosQr save(CodigosQr codigosQr);

    void inactivarCodigosQR(Long idEmpleado);
}
