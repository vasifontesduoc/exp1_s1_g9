package com.duoc.exp1_s1_g9.controller;

import com.duoc.exp1_s1_g9.entity.Inscripcion;
import com.duoc.exp1_s1_g9.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService service;

    @GetMapping
    public List<Inscripcion> listar() {
        return service.listarInscripciones();
    }

    @PostMapping
    public Inscripcion guardar(@RequestBody Inscripcion inscripcion) {
        return service.guardarInscripcion(inscripcion);
    }
}
