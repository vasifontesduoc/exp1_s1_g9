package com.duoc.exp1_s1_g9.service;

import com.duoc.exp1_s1_g9.entity.Curso;
import com.duoc.exp1_s1_g9.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> obtenerCursos() {
        return repository.findAll();
    }

    public Curso guardarCurso(Curso curso) {
        return repository.save(curso);
    }
}