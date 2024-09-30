package com.stylo.store.controllers;

import com.stylo.store.models.ProductoCategoria;
import com.stylo.store.services.ProductoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto-categoria")
@CrossOrigin(origins = "https://stylo-store-git-master-gabriels-projects-9c5cda58.vercel.app")
public class ProductoCategoriaController {

    @Autowired
    private ProductoCategoriaService productoCategoriaService;

    // Obtener todas las relaciones producto-categoría
    @GetMapping
    public List<ProductoCategoria> getAllProductoCategorias() {
        return productoCategoriaService.getAllProductoCategorias();
    }

    // Obtener todas las categorías de un producto específico
    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<ProductoCategoria>> obtenerCategoriasPorProducto(@PathVariable Long productoId) {
        return ResponseEntity.ok(productoCategoriaService.obtenerCategoriasPorProducto(productoId));
    }

    // Obtener una relación producto-categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoCategoria> getProductoCategoriaById(@PathVariable Long id) {
        Optional<ProductoCategoria> productoCategoria = productoCategoriaService.getProductoCategoriaById(id);
        return productoCategoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva relación producto-categoría
    @PostMapping
    public ProductoCategoria createProductoCategoria(@RequestBody ProductoCategoria productoCategoria) {
        return productoCategoriaService.saveProductoCategoria(productoCategoria);
    }

    // Actualizar una relación producto-categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<ProductoCategoria> updateProductoCategoria(@PathVariable Long id, @RequestBody ProductoCategoria productoCategoriaDetails) {
        Optional<ProductoCategoria> productoCategoria = productoCategoriaService.getProductoCategoriaById(id);
        if (productoCategoria.isPresent()) {
            ProductoCategoria updatedProductoCategoria = productoCategoria.get();
            updatedProductoCategoria.setProducto(productoCategoriaDetails.getProducto());
            updatedProductoCategoria.setCategoria(productoCategoriaDetails.getCategoria());
            return ResponseEntity.ok(productoCategoriaService.saveProductoCategoria(updatedProductoCategoria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una relación producto-categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductoCategoria(@PathVariable Long id) {
        Optional<ProductoCategoria> productoCategoria = productoCategoriaService.getProductoCategoriaById(id);
        if (productoCategoria.isPresent()) {
            productoCategoriaService.deleteProductoCategoria(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
