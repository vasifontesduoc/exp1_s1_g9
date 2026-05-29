package com.duoc.exp1_s1_g9.controller;

import com.duoc.exp1_s1_g9.dto.CursoDTO;
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
    public List<CursoDTO> listarCursos() {

        return service.obtenerCursos()
                .stream()
                .map(curso -> new CursoDTO(
                        curso.getId(),
                        curso.getNombre(),
                        curso.getDescripcion(),
                        curso.getDuracion()))
                .toList();
    }

    @PostMapping
    public CursoDTO guardarCurso(@RequestBody Curso curso) {

        Curso cursoGuardado = service.guardarCurso(curso);

        return new CursoDTO(
                cursoGuardado.getId(),
                cursoGuardado.getNombre(),
                cursoGuardado.getDescripcion(),
                cursoGuardado.getDuracion());
    }
}
