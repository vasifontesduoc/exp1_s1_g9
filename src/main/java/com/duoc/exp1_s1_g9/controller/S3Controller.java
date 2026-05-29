package com.duoc.exp1_s1_g9.controller;

import com.duoc.exp1_s1_g9.service.S3Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @DeleteMapping("/eliminar/{nombre}")
    public String eliminarArchivo(@PathVariable String nombre) {

        s3Service.eliminarArchivo(nombre);

        return "Archivo eliminado correctamente";
    }

    @GetMapping("/listar")
    public List<String> listarArchivos() {

        return s3Service.listarArchivos();
    }
}