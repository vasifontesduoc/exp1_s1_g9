package com.duoc.exp1_s1_g9.repository;

import com.duoc.exp1_s1_g9.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}