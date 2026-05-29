package com.duoc.exp1_s1_g9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer duracion;
}
