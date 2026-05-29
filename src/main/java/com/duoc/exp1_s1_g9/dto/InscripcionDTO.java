package com.duoc.exp1_s1_g9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionDTO {

    private Long id;
    private String estudiante;
    private String cursoNombre;
    private Double costo;
    private Integer cantidad;
    private String fecha;
    private Double total;
}

