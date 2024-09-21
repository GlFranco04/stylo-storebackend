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

import com.stylo.store.models.Ciudad;
import com.stylo.store.services.CiudadService;

@RestController
@RequestMapping("/api/ciudad")
public class CiudadController {
  @Autowired
  private CiudadService ciudadService;

  // Obtener todas las ciudades
  @GetMapping
  public List<Ciudad> getAllCiudades() {
    return ciudadService.getAllCiudades();
  }

  // Obtener una ciudad por ID
  @GetMapping("/{id}")
  public ResponseEntity<Ciudad> getCiudadById(@PathVariable Long id){
    Optional<Ciudad> ciudad = ciudadService.getCiudadById(id);
    return ciudad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear una nueva ciudad
  @PostMapping
  public Ciudad createCiudad(@RequestBody Ciudad ciudad) {
    return ciudadService.saveCiudad(ciudad);
  }
  // Actualizar una ciudad existente
  @PutMapping("/{id}")
  public ResponseEntity<Ciudad> updateCiudad(@PathVariable Long id, @RequestBody Ciudad ciudadDetails) {
    Optional<Ciudad> ciudad = ciudadService.getCiudadById(id);
    if (ciudad.isPresent()) {
      Ciudad updatedCiudad = ciudad.get();
      updatedCiudad.setNombre(ciudadDetails.getNombre());
      updatedCiudad.setNombre(ciudadDetails.getNombre());
      return ResponseEntity.ok(ciudadService.saveCiudad(updatedCiudad));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Eliminar una ciudad existente
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCiudad(@PathVariable Long id) {
    Optional<Ciudad> ciudad = ciudadService.getCiudadById(id);
    if (ciudad.isPresent()) {
      ciudadService.deleteCiudad(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
