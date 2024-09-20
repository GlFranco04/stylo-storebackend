package com.stylo.store.controllers;

import com.stylo.store.models.DetalleProducto;
import com.stylo.store.services.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle-producto")
public class DetalleProductoController {

    @Autowired
    private DetalleProductoService detalleProductoService;

    // Obtener todos los detalles de producto
    @GetMapping
    public List<DetalleProducto> getAllDetalleProductos() {
        return detalleProductoService.getAllDetalleProductos();
    }

    // Obtener un detalle de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalleProducto> getDetalleProductoById(@PathVariable Long id) {
        Optional<DetalleProducto> detalleProducto = detalleProductoService.getDetalleProductoById(id);
        return detalleProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo detalle de producto
    @PostMapping
    public DetalleProducto createDetalleProducto(@RequestBody DetalleProducto detalleProducto) {
        return detalleProductoService.saveDetalleProducto(detalleProducto);
    }

    // Actualizar un detalle de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<DetalleProducto> updateDetalleProducto(@PathVariable Long id, @RequestBody DetalleProducto detalleProductoDetails) {
        Optional<DetalleProducto> detalleProducto = detalleProductoService.getDetalleProductoById(id);
        if (detalleProducto.isPresent()) {
            DetalleProducto updatedDetalleProducto = detalleProducto.get();
            updatedDetalleProducto.setColor(detalleProductoDetails.getColor());
            updatedDetalleProducto.setPrecio(detalleProductoDetails.getPrecio());
            return ResponseEntity.ok(detalleProductoService.saveDetalleProducto(updatedDetalleProducto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un detalle de producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleProducto(@PathVariable Long id) {
        detalleProductoService.deleteDetalleProducto(id);
        return ResponseEntity.noContent().build();
    }
}
