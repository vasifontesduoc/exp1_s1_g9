package com.duoc.exp1_s1_g9.service;

import com.duoc.exp1_s1_g9.entity.Inscripcion;
import com.duoc.exp1_s1_g9.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository repository;

    public List<Inscripcion> listarInscripciones() {
        return repository.findAll();
    }

    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {

        inscripcion.setTotal(inscripcion.getCosto() * inscripcion.getCantidad());

        Inscripcion guardada = repository.save(inscripcion);

        generarArchivoTXT(guardada);

        return guardada;
    }

    private void generarArchivoTXT(Inscripcion inscripcion) {

        String nombreArchivo = "inscripcion_" + inscripcion.getId() + ".txt";

        String ruta = "src/main/resources/archivos/" + nombreArchivo;

        try (FileWriter writer = new FileWriter(ruta)) {

            writer.write("===== RESUMEN INSCRIPCION =====\n");
            writer.write("ID: " + inscripcion.getId() + "\n");
            writer.write("Estudiante: " + inscripcion.getEstudiante() + "\n");
            writer.write("Curso: " + inscripcion.getCursoNombre() + "\n");
            writer.write("Costo: " + inscripcion.getCosto() + "\n");
            writer.write("Cantidad: " + inscripcion.getCantidad() + "\n");
            writer.write("Fecha: " + inscripcion.getFecha() + "\n");
            writer.write("Total: " + inscripcion.getTotal() + "\n");

            System.out.println("Archivo TXT generado correctamente");

        } catch (IOException e) {

            System.out.println("Error al generar archivo TXT");
            e.printStackTrace();
        }
    }
}
