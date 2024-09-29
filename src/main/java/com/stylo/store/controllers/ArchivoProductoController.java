// ArchivoProductoController.java
package com.stylo.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stylo.store.models.ArchivoProducto;
import com.stylo.store.services.ArchivoProductoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/archivoProducto")
public class ArchivoProductoController {

    @Autowired
    private ArchivoProductoService archivoProductoService;

    // Endpoint para guardar un archivoProducto
    @PostMapping("/guardar")
    public ResponseEntity<ArchivoProducto> guardarArchivoProducto(@RequestBody ArchivoProducto archivoProducto) {
        archivoProductoService.guardarArchivoProducto(archivoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(archivoProducto);
    }

    // Endpoint para obtener un archivoProducto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ArchivoProducto> obtenerArchivoProductoPorId(@PathVariable Long id) {
        Optional<ArchivoProducto> archivoProductoOpt = archivoProductoService.obtenerArchivoProductoPorId(id);
        if (archivoProductoOpt.isPresent()) {
            return ResponseEntity.ok(archivoProductoOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint para eliminar un archivoProducto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArchivoProducto(@PathVariable Long id) {
        archivoProductoService.eliminarArchivoProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
