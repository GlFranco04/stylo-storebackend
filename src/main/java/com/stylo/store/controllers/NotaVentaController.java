package com.stylo.store.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylo.store.services.NotaVentaService;
import com.stylo.store.models.NotaVenta;

@RestController
@RequestMapping("/api/nota-venta")
@CrossOrigin(origins = "https://stylo-store-git-master-gabriels-projects-9c5cda58.vercel.app")
public class NotaVentaController {
  @Autowired
  private NotaVentaService notaVentaService;

  // Obtener todas las notasventas
  @GetMapping
  public List<NotaVenta> getAllNotasVentas() {
    return notaVentaService.obtenerTodasLasNotasVenta();
  }

  // Obtener una nota de venta por ID
  @GetMapping("/{id}")
  public ResponseEntity<NotaVenta> getNotaVentaById(@PathVariable Long id) {
    Optional<NotaVenta> notaventa = notaVentaService.obtenerNotaVentaPorId(id);
    return notaventa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear una nueva nota de venta
  @PostMapping
  public NotaVenta createNotaVenta(@RequestBody NotaVenta notaventa) {
    return notaVentaService.saveNotaVenta(notaventa);
  }

  // Actualizar una nota de venta existente
  @PutMapping("/{id}")
  public ResponseEntity<NotaVenta> updateNotaVenta(@PathVariable Long id, @RequestBody NotaVenta notaventaDetails) {
    Optional<NotaVenta> notaventa = notaVentaService.obtenerNotaVentaPorId(id);
    if (notaventa.isPresent()) {
      NotaVenta updatedNotaVenta = notaventa.get();
      updatedNotaVenta.setSucursal(notaventaDetails.getSucursal());
      updatedNotaVenta.setFechaVenta(notaventaDetails.getFechaVenta());
      updatedNotaVenta.setDetalleVentas(notaventaDetails.getDetalleVentas());
      return ResponseEntity.ok(notaVentaService.saveNotaVenta(updatedNotaVenta));
    }
    return ResponseEntity.notFound().build();
  }

  // Eliminar una Nota Venta
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNotaVenta(@PathVariable Long id) {
    Optional<NotaVenta> notaventa = notaVentaService.obtenerNotaVentaPorId(id);
    if (notaventa.isPresent()) {
      notaVentaService.eliminarNotaVenta(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

}
