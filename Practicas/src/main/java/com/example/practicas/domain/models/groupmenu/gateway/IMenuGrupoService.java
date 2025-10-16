package com.example.practicas.domain.models.groupmenu.gateway;

import com.example.practicas.infrastructure.entrypoints.dto.MenuConsultaDTO;

import java.util.List;

public interface IMenuGrupoService {

    List<MenuConsultaDTO> menuByGrupo(String grupo);
}
