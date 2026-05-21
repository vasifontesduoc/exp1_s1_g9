package com.duoc.exp1_s1_g9.controller;

import com.duoc.exp1_s1_g9.entity.Curso;
import com.duoc.exp1_s1_g9.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping("/mensaje")
    public String hola() {
        return "Proyecto funcionando";
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return service.obtenerCursos();
    }

    @PostMapping
    public Curso guardarCurso(@RequestBody Curso curso) {
        return service.guardarCurso(curso);
    }
}