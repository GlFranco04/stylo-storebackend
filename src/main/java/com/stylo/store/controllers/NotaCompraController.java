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

import com.stylo.store.models.NotaCompra;
import com.stylo.store.services.NotaCompraService;

@RestController
@RequestMapping("/api/nota-compra")
public class NotaCompraController {
    @Autowired
    private NotaCompraService notaCompraService;

  // Obtener todas las notasventas
  @GetMapping
  public List<NotaCompra> getAllNotasVentas() {
    return notaCompraService.obtenerTodasLasNotasCompra();
  }

  // Obtener una nota de venta por ID
  @GetMapping("/{id}")
  public ResponseEntity<NotaCompra> getNotaCompraById(@PathVariable Long id) {
    Optional<NotaCompra> notacompra = notaCompraService.obtenerNotaCompraPorId(id);
    return notacompra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear una nueva nota de venta
  @PostMapping
  public NotaCompra createNotaCompra(@RequestBody NotaCompra notacompra) {
    return notaCompraService.saveNotaCompra(notacompra);
  }

  // Actualizar una nota de venta existente
  @PutMapping("/{id}")
  public ResponseEntity<NotaCompra> updateNotaCompra(@PathVariable Long id, @RequestBody NotaCompra notacompraDetails) {
    Optional<NotaCompra> notacompra = notaCompraService.obtenerNotaCompraPorId(id);
    if (notacompra.isPresent()) {
      NotaCompra updatedNotaCompra = notacompra.get();
      updatedNotaCompra.setSucursal(notacompraDetails.getSucursal());
      updatedNotaCompra.setFechaVenta(notacompraDetails.getFechaVenta());
      updatedNotaCompra.setDetalleCompras(notacompraDetails.getDetalleCompras());
      return ResponseEntity.ok(notaCompraService.saveNotaCompra(updatedNotaCompra));
    }
    return ResponseEntity.notFound().build();
  }

  // Eliminar una Nota Venta
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNotaVenta(@PathVariable Long id) {
    Optional<NotaCompra> notacompra = notaCompraService.obtenerNotaCompraPorId(id);
    if (notacompra.isPresent()) {
      notaCompraService.eliminarNotaCompra(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
