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

import com.stylo.store.models.Direccion;
import com.stylo.store.services.DireccionService;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {
  @Autowired
  private DireccionService direccionService;

  // Obtener todas las direcciones
  @GetMapping
  public List<Direccion> getAllDirecciones() {
    return direccionService.getAllDirecciones();
  }

  // Endpoint para obtener las direcciones no asignadas
  @GetMapping("/disponibles")
  public ResponseEntity<List<Direccion>> obtenerDireccionesDisponibles() {
      List<Direccion> direccionesDisponibles = direccionService.obtenerDireccionesNoAsignadas();
      return ResponseEntity.ok(direccionesDisponibles);
  }

  // Obtener una dirección por ID
  @GetMapping("/{id}")
  public ResponseEntity<Direccion> getDireccionById(@PathVariable Long id){
    Optional<Direccion> direccion = direccionService.getDireccionById(id);
    return direccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  } 

  // Crear una nueva dirección
  @PostMapping
  public Direccion createDireccion(@RequestBody Direccion direccion) {
    return direccionService.saveDireccion(direccion);
  }

  // Actualizar una dirección existente
  @PutMapping("/{id}")
  public ResponseEntity<Direccion> updateDireccion(@PathVariable Long id, @RequestBody Direccion direccionDetails) {
    Optional<Direccion> direccion = direccionService.getDireccionById(id);
    if (direccion.isPresent()) {
      Direccion updatedDireccion = direccion.get();
      updatedDireccion.setNombre(direccionDetails.getNombre());
      updatedDireccion.setUbicacion(direccionDetails.getUbicacion());
      updatedDireccion.setEdificio(direccionDetails.getEdificio());
      updatedDireccion.setCiudad(direccionDetails.getCiudad());
      return ResponseEntity.ok(direccionService.saveDireccion(updatedDireccion));
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  // Eliminar una dirección
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDireccion(@PathVariable Long id) {
    Optional<Direccion> direccion = direccionService.getDireccionById(id);
    if (direccion.isPresent()) {
      direccionService.deleteDireccion(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
