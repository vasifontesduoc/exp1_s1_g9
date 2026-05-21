package com.duoc.exp1_s1_g9.service;

import com.duoc.exp1_s1_g9.entity.Inscripcion;
import com.duoc.exp1_s1_g9.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository repository;

    public List<Inscripcion> listarInscripciones() {
        return repository.findAll();
    }

    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
        inscripcion.setTotal(inscripcion.getCosto());
        return repository.save(inscripcion);
    }
}
