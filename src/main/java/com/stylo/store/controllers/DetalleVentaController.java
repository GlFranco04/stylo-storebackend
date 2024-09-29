package com.stylo.store.controllers;

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

import java.util.List;
import java.util.Optional;
import com.stylo.store.models.DetalleVenta;
import com.stylo.store.services.DetalleVentaService;

@RestController
@RequestMapping("/api/detalle-venta")
public class DetalleVentaController {
  @Autowired
  private DetalleVentaService detalleVentaService;

  // Obtener todas las notasventas
  @GetMapping
  public List<DetalleVenta> getAllDetallesVenta() {
    return detalleVentaService.obtenerTodosLosDetallesVenta();
  }

  // Obtener una nota de venta por ID
  @GetMapping("/{id}")
  public ResponseEntity<DetalleVenta> getNotaVentaById(@PathVariable Long id) {
    Optional<DetalleVenta> detalleventa = detalleVentaService.obtenerDetalleVentaPorId(id);
    return detalleventa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear una nueva nota de venta
  @PostMapping
  public DetalleVenta createNotaVenta(@RequestBody DetalleVenta detalleventa) {
    return detalleVentaService.saveDetalleVenta(detalleventa);
  }

  // Actualizar una nota de venta existente
  @PutMapping("/{id}")
  public ResponseEntity<DetalleVenta> updateNotaVenta(@PathVariable Long id, @RequestBody DetalleVenta detalleventaDetails) {
    Optional<DetalleVenta> detalleventa = detalleVentaService.obtenerDetalleVentaPorId(id);
    if (detalleventa.isPresent()) {
      DetalleVenta updatedDetalleVenta = detalleventa.get();
      updatedDetalleVenta.setCantidad(detalleventaDetails.getCantidad());
      updatedDetalleVenta.setDetalleProducto(detalleventaDetails.getDetalleProducto());
      return ResponseEntity.ok(detalleVentaService.saveDetalleVenta(updatedDetalleVenta));
    }
    return ResponseEntity.notFound().build();
  }

  // Eliminar una Nota Venta
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNotaVenta(@PathVariable Long id) {
    Optional<DetalleVenta> detalleventa = detalleVentaService.obtenerDetalleVentaPorId(id);
    if (detalleventa.isPresent()) {
      detalleVentaService.eliminarDetalleVenta(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
