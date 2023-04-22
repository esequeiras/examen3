package com.cenfotec.examen3.controllers;

import com.cenfotec.examen3.domain.Equipo;
import com.cenfotec.examen3.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipos")
public class EquipoController {
    @Autowired
    EquipoService equipoService;
    @PostMapping(value = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Long guardarEquipo(@RequestBody Equipo nuevo) {
        return equipoService.guardarEquipo(nuevo);
    }
    @GetMapping(value="/", produces = "application/json")
    public List<Equipo> listarEquipos(){
        return equipoService.listar();
    }

}
