package com.example.practicas.infrastructure.drivenadapters.dao.groupmenu.adapter;

import com.example.practicas.infrastructure.entrypoints.dto.groupmenu.MenuConsultaDTO;
import com.example.practicas.domain.models.groupmenu.models.MenuGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMenuGrupoDao extends JpaRepository<MenuGrupo, Long> {
    @Query("select new com.example.practicas.models.dto.MenuConsultaDTO(mo.idMenuOpcion, mo.nombreMenuOpcion, mo.descripcionMenuOpcion, mo.iconoMenuOpcion, mo.rutaMenuOpcion, mo.estadoMenuOpcion, mo.idPadreMenuOpcion, mo.ordenMenuOpcion, mo.claveMenuOpcion, mg.idMenuOpcion, mg.nombreMenuGrupo, mg.estadoMenuGrupo) from MenuGrupo mg " +
            "inner join mg.menuOpcion mo " +
            "where mg.nombreMenuGrupo = ?1 "
    )
    List<MenuConsultaDTO> findMenuByGrupo(String nombreGrupo);
}
