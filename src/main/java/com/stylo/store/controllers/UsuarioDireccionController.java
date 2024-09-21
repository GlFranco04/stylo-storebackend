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

import com.stylo.store.models.UsuarioDireccion;
import com.stylo.store.services.UsuarioDireccionService;

@RestController
@RequestMapping("/api/usuario-direccion")
public class UsuarioDireccionController {
  @Autowired
  private UsuarioDireccionService usuarioDireccionService;

  // Obtener todos los usuarioDireccion
  @GetMapping
  public List<UsuarioDireccion> getAllUsuarioDirecciones() {
    return usuarioDireccionService.getAllUsuarioDirecciones();
  }

  // Obtener una usuarioDireccion por ID
  @GetMapping("/{id}")
  public ResponseEntity<UsuarioDireccion> getUsuarioDireccionById(@PathVariable Long id) {
    Optional<UsuarioDireccion> usuarioDireccion = usuarioDireccionService.getUsuarioDireccionById(id);
    return usuarioDireccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear una nueva usuarioDireccion
  @PostMapping
  public UsuarioDireccion createUsuarioDireccion(@RequestBody UsuarioDireccion usuarioDireccion) {
    return usuarioDireccionService.saveUsuarioDireccion(usuarioDireccion);
  }
  // Actualizar una usuarioDireccion existente
  @PutMapping("/{id}")
  public ResponseEntity<UsuarioDireccion> updateUsuarioDireccion(@PathVariable Long id, @RequestBody UsuarioDireccion usuarioDireccionDetails) {
    Optional<UsuarioDireccion> usuarioDireccion = usuarioDireccionService.getUsuarioDireccionById(id);
    if (usuarioDireccion.isPresent()) {
      UsuarioDireccion updatedUsuarioDireccion = usuarioDireccion.get();
      updatedUsuarioDireccion.setFechaCreacion(usuarioDireccionDetails.getFechaCreacion());
      return ResponseEntity.ok(usuarioDireccionService.saveUsuarioDireccion(updatedUsuarioDireccion));
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  // Eliminar una usuarioDireccion
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUsuarioDireccion(@PathVariable Long id) {
    Optional<UsuarioDireccion> usuarioDireccion = usuarioDireccionService.getUsuarioDireccionById(id);
    if (usuarioDireccion.isPresent()) {
      usuarioDireccionService.deleteUsuarioDireccion(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
