package com.example.practicas.domain.usecase.employeeservice;

import com.example.practicas.domain.models.employeeservice.gateway.IEmpleadoService;
import com.example.practicas.infrastructure.drivenadapters.dao.employeeservice.adapter.IEmpleadoDao;
import com.example.practicas.domain.models.employeeservice.model.Empleado;
import com.example.practicas.domain.models.shared.exceptions.NoContentException;
import com.example.practicas.infrastructure.drivenadapters.mappers.EmpleadoMapper;
import com.example.practicas.infrastructure.entrypoints.dto.employeeservice.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

  private final IEmpleadoDao empleadoDao;

    @Override
    public List<EmpleadoConsultaDTO> findAll() {

        return empleadoDao.findEmpleados();
    }

    @Override
    public EmpleadoConsultaDTO findById(Long id) {
        return empleadoDao.findEmpleadosForId(id)
                .orElseThrow(() -> new NoContentException(MessageFormat
                        .format("El empleado {0} no se ha encontrado.", id)));
    }

    @Override
    public List<EmpleadoConsultaByIdDTO> findByIdAll(Long id) {
        return empleadoDao.findEmpleadosForIdAllData(id);
    }

    @Transactional
    @Override
    public Empleado save(EmpleadoPersistenciaDTO empleado) {
        Empleado empleadoEntity = EmpleadoMapper.INSTANCIA.dtoPersistenciaToEntity(empleado);
        return empleadoDao.save(empleadoEntity);
    }

    @Override
    public void delete(Long id) {
        Empleado empleadoRecibido = empleadoDao.findById(id)
                        .orElseThrow(() -> new NoContentException(MessageFormat
                                .format("Empleado con id {0} a elimianr no existe", id)));
        empleadoDao.deleteById(id);
    }

    @Override
    public Empleado update(Empleado empleado, Long id) {
        Empleado empleadoActual = empleadoDao.findById(id)
                .orElseThrow(()-> new NoContentException(MessageFormat
                        .format("Empleado no encontrado con ID: {0}" , id)));

            empleadoActual.setNombre((empleado.getNombre()));
            empleadoActual.setApellido(empleado.getApellido());
            empleadoActual.setCargo(empleado.getCargo());
            empleadoActual.setArea(empleado.getArea());
            empleadoActual.setTipoContrato(empleado.getTipoContrato());
            empleadoActual.setProyecto(empleado.getProyecto());

            return empleadoDao.save(empleadoActual);

    }

    @Override
    public List<ProyectosEmpleadoDTO> proyectsForEmployee(Long id){
        return empleadoDao.findProyectsForEmployee(id);
    }

    @Override
    public List<EmpleadosByEquiposDTO> EquiposById(Long id) {
        return empleadoDao.findEmpleadosByEquipoId(id);
    }

/*
    public EmpleadoInfoDetalladaDTO infoEmpleadoDetallada(Long id){
        Empleado empleadoRecibido = empleadoDao.findById(id)
                .orElseThrow(() -> new NoContentException(MessageFormat
                        .format("Empleado con id {0} a elimianr no existe", id)));
        EmpleadoInfoDetalladaDTO empleadoDto = new EmpleadoInfoDetalladaDTO();
        empleadoDto.setIdEmpleado(empleadoRecibido.getIdEmpleado());
        empleadoDto.setNombre(empleadoDto.getNombre());
        empleadoDto.setApellido(empleadoDto.getApellido());
        empleadoDto.setDocumento(empleadoDto.getDocumento());

        List<ProyectosEmpleadoDTO> proyectosPorEmpleados = empleadoRecibido.getIdProyecto().stream()
                .map(this::mapProyectoToDTO) // Mapea cada proyecto a su DTO correspondiente
                .collect(Collectors.toList());

        List<ProyectosEmpleadoDTO> proyectosPorEmpleados = new ArrayList<>();
        for (Proyecto proyecto : empleadoRecibido.getIdProyecto()){
            ProyectosEmpleadoDTO proyectoDto = new ProyectosEmpleadoDTO();
            proyectoDto.setNombre(proyecto.getNombre());
            proyectoDto.setDescripcionProyecto(proyectoDto.getDescripcionProyecto());
            proyectosPorEmpleados.add(proyectoDto);
        }
        empleadoDto.setProyectos(proyectosPorEmpleados);

        return empleadoDto;
    }

    private ProyectosEmpleadoDTO mapProyectoToDTO(Proyecto proyecto) {
        ProyectosEmpleadoDTO proyectoDto = new ProyectosEmpleadoDTO();
        proyectoDto.setNombre(proyecto.getNombre());
        proyectoDto.setDescripcionProyecto(proyecto.getDescripcionProyecto());
        // Otras asignaciones relevantes para el DTO
        return proyectoDto;
    }

*/



}
