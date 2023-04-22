package com.cenfotec.examen3.services;

import com.cenfotec.examen3.domain.Equipo;
import com.cenfotec.examen3.repos.EquipoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    @Autowired
    EquipoData equipoRepo;
    public Long  guardarEquipo(Equipo nuevo){
        return equipoRepo.save(nuevo).getId();

    }

    public List<Equipo> listar() {
        return equipoRepo.findAll();
    }

}
