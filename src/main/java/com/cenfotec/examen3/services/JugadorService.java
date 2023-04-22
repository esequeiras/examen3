package com.cenfotec.examen3.services;


import com.cenfotec.examen3.domain.Jugador;
import com.cenfotec.examen3.repos.JugadorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    JugadorData jugadorRepo;
    public Long  guardarJugador(Jugador nuevo){
        return jugadorRepo.save(nuevo).getId();

    }

    public Page<Jugador> listar(Pageable pageable) {
        return jugadorRepo.findAll(pageable);
    }
    public Jugador getId(long id){
        Optional<Jugador> resultado =  jugadorRepo.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            return null;
        }
    }
    public boolean borrarJuga(Long id) {
        jugadorRepo.deleteById(id);
        return true;
    }
    public  Optional<Jugador> update(Jugador jugador) {
        Optional<Jugador> jug = jugadorRepo.findById(jugador.getId());
        if (jug.isPresent()) {
            Jugador datosJugador = jug.get();
            datosJugador.setNombre(jugador.getNombre());
            datosJugador.setApellido1(jugador.getApellido1());
            datosJugador.setApellido2(jugador.getApellido2());
            datosJugador.setPosicion(jugador.getPosicion());
            datosJugador.setPiernaDominante(jugador.getPiernaDominante());
            datosJugador.setFechaNacimiento(jugador.getFechaNacimiento());
            datosJugador.setEstatura(jugador.getEstatura());
            datosJugador.setPeso(jugador.getPeso());
            datosJugador.setEstado(jugador.isEstado());
            return Optional.of(jugadorRepo.save(datosJugador));
        }
        return Optional.empty();
    }

}
