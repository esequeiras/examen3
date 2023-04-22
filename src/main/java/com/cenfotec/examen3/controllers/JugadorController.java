package com.cenfotec.examen3.controllers;

import com.cenfotec.examen3.domain.Jugador;
import com.cenfotec.examen3.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("jugadores")
public class JugadorController {
    @Autowired
    JugadorService jugadorService;
    @PostMapping(value = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Long guardarPersonas(@RequestBody Jugador nuevo) {
        return jugadorService.guardarJugador(nuevo);
        }
    @GetMapping(value="/", produces = "application/json")
    public Page<Jugador> listarJugadores(Pageable pageable){
        return jugadorService.listar(pageable);
    }
    @DeleteMapping(value="/{id}", produces = "application/json")
    public void borrarPersonas(@PathVariable long id){
        jugadorService.borrarJuga(id);
    }
    @GetMapping(value="/{id}", produces = "application/json")
    public Jugador obtenerJugadorPorId(@PathVariable long id){
        return jugadorService.getId(id);
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<Jugador> update(@PathVariable("id") long id,
                                          @RequestBody Jugador jugador){
        jugador.setId(id);
        Optional<Jugador> result = jugadorService.update(jugador);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
