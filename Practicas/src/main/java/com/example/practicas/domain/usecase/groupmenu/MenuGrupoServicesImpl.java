package com.example.practicas.domain.usecase.groupmenu;

import com.example.practicas.domain.models.groupmenu.gateway.IMenuGrupoService;
import com.example.practicas.infrastructure.drivenadapters.dao.IMenuGrupoDao;
import com.example.practicas.infrastructure.entrypoints.dto.MenuConsultaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuGrupoServicesImpl implements IMenuGrupoService {
    private final IMenuGrupoDao menuGrupoDao;
    @Override
    public List<MenuConsultaDTO> menuByGrupo(String grupo) {
        return menuGrupoDao.findMenuByGrupo(grupo);
    }
}
