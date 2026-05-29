package com.duoc.exp1_s1_g9.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.util.List;

@Service
public class S3Service {

    private final S3Client s3Client;

    @Value("${aws.bucketName}")
    private String bucketName;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void subirArchivo(File archivo) {

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key("inscripciones/" + archivo.getName())
                .build();

        s3Client.putObject(
                request,
                RequestBody.fromFile(archivo));

        System.out.println("Archivo subido correctamente a S3");
    }

    public void eliminarArchivo(String nombreArchivo) {

        s3Client.deleteObject(builder -> builder
                .bucket(bucketName)
                .key("inscripciones/" + nombreArchivo)
                .build());

        System.out.println("Archivo eliminado correctamente de S3");
    }

    public List<String> listarArchivos() {

        return s3Client.listObjectsV2(builder -> builder
                .bucket(bucketName)
                .prefix("inscripciones/")
                .build())
                .contents()
                .stream()
                .map(s3Object -> s3Object.key())
                .toList();
    }

}
