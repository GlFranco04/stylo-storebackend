package com.stylo.store.controllers;

import com.stylo.store.models.Producto;
import com.stylo.store.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    @PreAuthorize("hasAuthority('ver_producto')")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.getProductoById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Optional<Producto> producto = productoService.getProductoById(id);
        if (producto.isPresent()) {
            Producto updatedProducto = producto.get();
            updatedProducto.setNombre(productoDetails.getNombre());
            updatedProducto.setDescripcion(productoDetails.getDescripcion());
            updatedProducto.setFechaCreacion(productoDetails.getFechaCreacion());
            updatedProducto.setEstaActivo(productoDetails.isEstaActivo());
            return ResponseEntity.ok(productoService.saveProducto(updatedProducto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Desactivar un producto (soft delete)
    @PatchMapping("/{id}")
    public ResponseEntity<Void> deactivateProducto(@PathVariable Long id) {
        productoService.toggleProductoStatus(id);
        return ResponseEntity.noContent().build();
    }
    
}
