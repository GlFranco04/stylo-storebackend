package com.stylo.store.controllers;

import com.stylo.store.models.Categoria;
import com.stylo.store.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.getCategoriaById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva categoría
    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
        Optional<Categoria> categoria = categoriaService.getCategoriaById(id);
        if (categoria.isPresent()) {
            Categoria updatedCategoria = categoria.get();
            updatedCategoria.setNombre(categoriaDetails.getNombre());
            updatedCategoria.setDescripcion(categoriaDetails.getDescripcion());
            updatedCategoria.setEstaActivo(categoriaDetails.isEstaActivo());
            return ResponseEntity.ok(categoriaService.saveCategoria(updatedCategoria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Desactivar o activar una categoría (soft delete)
    @PatchMapping("/{id}")
    public ResponseEntity<Void> toggleCategoriaStatus(@PathVariable Long id) {
        categoriaService.toggleCategoriaStatus(id);
        return ResponseEntity.noContent().build();
    }
}
