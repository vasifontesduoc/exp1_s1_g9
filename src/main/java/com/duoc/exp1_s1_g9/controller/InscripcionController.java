package com.duoc.exp1_s1_g9.controller;

import com.duoc.exp1_s1_g9.dto.InscripcionDTO;
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
    public List<InscripcionDTO> listar() {

        return service.listarInscripciones()
                .stream()
                .map(inscripcion -> new InscripcionDTO(
                        inscripcion.getId(),
                        inscripcion.getEstudiante(),
                        inscripcion.getCursoNombre(),
                        inscripcion.getCosto(),
                        inscripcion.getCantidad(),
                        inscripcion.getFecha(),
                        inscripcion.getTotal()
                ))
                .toList();
    }

    @PostMapping
    public InscripcionDTO guardar(@RequestBody Inscripcion inscripcion) {

        Inscripcion guardada = service.guardarInscripcion(inscripcion);

        return new InscripcionDTO(
                guardada.getId(),
                guardada.getEstudiante(),
                guardada.getCursoNombre(),
                guardada.getCosto(),
                guardada.getCantidad(),
                guardada.getFecha(),
                guardada.getTotal()
        );
    }
}
