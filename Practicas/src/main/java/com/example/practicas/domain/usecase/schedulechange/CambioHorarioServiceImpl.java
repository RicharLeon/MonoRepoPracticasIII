package com.example.practicas.domain.usecase.schedulechange;

import com.example.practicas.domain.models.shared.exceptions.NoContentException;
import com.example.practicas.domain.models.schedulechange.gateway.ICambioHorarioService;
import com.example.practicas.domain.models.shared.values.Constantes;
import com.example.practicas.infrastructure.drivenadapters.dao.employeeassistance.adapter.IEmployeeAssistanceDao;
import com.example.practicas.infrastructure.drivenadapters.dao.schedulechange.adapter.ICambioHorarioDao;
import com.example.practicas.infrastructure.entrypoints.dto.schedulechange.CambioHorarioConsultaDTO;
import com.example.practicas.domain.models.schedulechange.model.CambioHorario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CambioHorarioServiceImpl implements ICambioHorarioService {

    private final ICambioHorarioDao cambioHorarioDao;
    private final IEmployeeAssistanceDao employeeAssistanceDao;

    @Override
    public Page<CambioHorarioConsultaDTO> findAll(@PageableDefault(page = 0, size=10) Pageable pageable) {
        return cambioHorarioDao.findCambiodeHorarioForNamesEmployee(pageable);
    }

    @Override
    public Page<CambioHorarioConsultaDTO> findByNameAndId(Long id,Pageable pageable) {
        return cambioHorarioDao.findCambiodeHorarioForNamesEmployeeForId(id, pageable);
    }

    @Override
    public Optional<CambioHorarioConsultaDTO> findById(Long id) {
        return cambioHorarioDao.findCambiodeHorarioPorId(id);
    }

    @Transactional
    @Override
    public CambioHorario save(CambioHorario cambioHorario) {
        validateAssitanceService(cambioHorario.getIdEmpleadoCambio(), cambioHorario);
        return cambioHorarioDao.save(cambioHorario);
    }

    @Override
    public void delete(Long id) {
        CambioHorario cambioHorarioRecibido = cambioHorarioDao.findById(id)
                .orElseThrow(()-> new NoContentException(MessageFormat
                        .format("Solicitud con id {0} a elimianr no existe", id)));
        cambioHorarioDao.deleteById(id);
    }

    @Override
    public CambioHorario update(CambioHorario cambioHorario, Long id) {
        validateAssitanceServiceUpdate(cambioHorario.getIdEmpleadoCambio(), cambioHorario);
        CambioHorario cambioHorarioRecibido = cambioHorarioDao.findById(id)
                .orElseThrow(()-> new NoContentException(MessageFormat
                        .format("Solicitud con id {0} a editar no existe", id)));
        cambioHorarioRecibido.setEstado(cambioHorario.getEstado());
        cambioHorarioRecibido.setIdEmpleadoCambio(cambioHorario.getIdEmpleadoCambio());
        cambioHorarioRecibido.setIdEmpleadoAprobador(cambioHorario.getIdEmpleadoAprobador());
        cambioHorarioRecibido.setIdEmpleadoSolicitante(cambioHorario.getIdEmpleadoSolicitante());
        cambioHorarioRecibido.setDescripcion(cambioHorario.getDescripcion());

        return cambioHorarioDao.save(cambioHorarioRecibido);
    }

    public CambioHorario validateAssitanceService(Long idEmployeeChange, CambioHorario cambioHorario) {
        var assitanceInSpecificDay = employeeAssistanceDao
                .getEmployeeAssitanceInSpecificDay(cambioHorario.getDiaCambio(),
                cambioHorario.getIdEmpleadoCambio());
        if(assitanceInSpecificDay==null || assitanceInSpecificDay < Constantes.NUMBER_ONE) {
            throw new NoContentException(String.format("EMPLEADO A CAMBIAR NO TIENE REGISTRO DE ASISTENCIA, EL DIA %s",
                    cambioHorario.getDiaCambio()));
        }
        return cambioHorario;
    }

    public CambioHorario validateAssitanceServiceUpdate(Long idEmployeeChange, CambioHorario cambioHorario) {
        var dayChange = LocalDate.parse(cambioHorario.getDiaCambio());
            if (cambioHorario.getEstado()){
                employeeAssistanceDao.updateEmployeeChangeAssitance(idEmployeeChange,
                        dayChange);
                return cambioHorario;
            }
            return cambioHorario;
    }
}
