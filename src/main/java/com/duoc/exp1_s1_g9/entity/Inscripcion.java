package com.duoc.exp1_s1_g9.entity;

import jakarta.persistence.*;

@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estudiante;

    private String cursoNombre;

    private Double costo;

    private Double total;

    public Inscripcion() {
    }

    public Inscripcion(Long id, String estudiante, String cursoNombre, Double costo, Double total) {
        this.id = id;
        this.estudiante = estudiante;
        this.cursoNombre = cursoNombre;
        this.costo = costo;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public Double getCosto() {
        return costo;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}