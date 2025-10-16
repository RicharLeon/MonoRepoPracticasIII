package com.example.practicas.domain.usecase.shared.qrcodes;

import com.example.practicas.domain.models.shared.exceptions.NoContentException;
import com.example.practicas.domain.models.shared.qrcodes.gateway.ICodigosQrService;
import com.example.practicas.infrastructure.drivenadapters.dao.shared.qrcodes.adapter.ICodigosQrDao;
import com.example.practicas.infrastructure.drivenadapters.dao.employeeservice.adapter.IEmpleadoDao;
import com.example.practicas.infrastructure.entrypoints.dto.shared.qrcodes.CodigosQrConsultaDTO;
import com.example.practicas.domain.models.shared.qrcodes.model.CodigosQr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CodigosQrServiceImpl implements ICodigosQrService {

    private final ICodigosQrDao codigosQrDao;
    private final IEmpleadoDao empleadoDao;


    @Override
    public List<CodigosQrConsultaDTO> mostrarQrPorEmpleado(Long id) {
         empleadoDao.findById(id)
                 .orElseThrow(() -> new NoContentException(MessageFormat
                 .format("El empleado {0} no se ha encontrado.", id)));
         return codigosQrDao.consultaQrEmpleado(id);
    }

    @Override
    public CodigosQrConsultaDTO mostrarQrPorEmpleadoActivo(Long id) {
        return codigosQrDao.consultaQrEmpleadoActivo(id)
                .orElseThrow(() -> new NoContentException(MessageFormat
                        .format("El empleado {0} no se ha encontrado.", id)));
    }


    @Override
    public CodigosQr save(CodigosQr codigosQr) {
        return codigosQrDao.save(codigosQr);
    }

    @Transactional
    @Override
    public void inactivarCodigosQR(Long idEmpleado){
        codigosQrDao.findByIdEmpleadoAndEstado(idEmpleado, true)
                .stream()
                .map( cq -> {
                    cq.setEstado(false);
                    return cq;
                }).forEach( codigosQrDao :: save);
    }
}
