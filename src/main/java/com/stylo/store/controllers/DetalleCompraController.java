package com.stylo.store.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylo.store.models.DetalleCompra;
import com.stylo.store.services.DetalleCompraService;

@RestController
@RequestMapping("/api/detalle-compra")
public class DetalleCompraController {
  @Autowired
  private DetalleCompraService detalleCompraService;

  // Obtener todas las notasventas
  @GetMapping
  public List<DetalleCompra> getAllDetallesCompra() {
    return detalleCompraService.obtenerTodosLosDetallesCompra();
  }

  // Obtener una nota de venta por ID
  @GetMapping("/{id}")
  public ResponseEntity<DetalleCompra> getNotaCompraById(@PathVariable Long id) {
    Optional<DetalleCompra> detallecompra = detalleCompraService.obtenerDetalleCompraPorId(id);
    return detallecompra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear una nueva nota de venta
  @PostMapping
  public DetalleCompra createNotaCompra(@RequestBody DetalleCompra detallecompra) {
    return detalleCompraService.saveDetalleCompra(detallecompra);
  }

  // Actualizar una nota de venta existente
  @PutMapping("/{id}")
  public ResponseEntity<DetalleCompra> updateNotaCompra(@PathVariable Long id, @RequestBody DetalleCompra detallecompraDetails) {
    Optional<DetalleCompra> detallecompra = detalleCompraService.obtenerDetalleCompraPorId(id);
    if (detallecompra.isPresent()) {
      DetalleCompra updatedDetalleCompra = detallecompra.get();
      updatedDetalleCompra.setCantidad(detallecompraDetails.getCantidad());
      updatedDetalleCompra.setDetalleProducto(detallecompraDetails.getDetalleProducto());
      return ResponseEntity.ok(detalleCompraService.saveDetalleCompra(updatedDetalleCompra));
    }
    return ResponseEntity.notFound().build();
  }

  // Eliminar una Nota Venta
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNotaCompra(@PathVariable Long id) {
    Optional<DetalleCompra> detallecompra = detalleCompraService.obtenerDetalleCompraPorId(id);
    if (detallecompra.isPresent()) {
      detalleCompraService.eliminarDetalleCompra(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
