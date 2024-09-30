// ArchivoController.java
package com.stylo.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.stylo.store.models.Archivo;
import com.stylo.store.services.ArchivoService;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/archivo")
@CrossOrigin(origins = "https://stylo-store-git-master-gabriels-projects-9c5cda58.vercel.app")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    // Endpoint para subir un archivo
    @PostMapping("/subir")
    public ResponseEntity<String> subirArchivo(@RequestParam("file") MultipartFile file) {
        try {
            String ubicacionArchivo = archivoService.guardarArchivo(file);
            return ResponseEntity.ok("Archivo subido exitosamente: " + ubicacionArchivo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    // Endpoint para obtener un archivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Archivo> obtenerArchivoPorId(@PathVariable Long id) {
        Optional<Archivo> archivoOpt = archivoService.obtenerArchivoPorId(id);
        if (archivoOpt.isPresent()) {
            return ResponseEntity.ok(archivoOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint para eliminar un archivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArchivo(@PathVariable Long id) {
        archivoService.eliminarArchivo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
