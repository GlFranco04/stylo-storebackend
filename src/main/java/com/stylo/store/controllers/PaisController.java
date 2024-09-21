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

import com.stylo.store.models.Pais;
import com.stylo.store.services.PaisService;

@RestController
@RequestMapping("/api/pais")
public class PaisController {
  @Autowired
  private PaisService paisService;

  // Obtener todos los paises
  @GetMapping
  public List<Pais> getAllPaises() {
    return paisService.getAllPaises();
  }

  // Obtener un pais por ID
  @GetMapping("/{id}")
  public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
    Optional<Pais> pais = paisService.getPaisById(id);
    return pais.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
  // Crear un nuevo pais
  @PostMapping
  public Pais createPais(@RequestBody Pais pais) {
    return paisService.savePais(pais);
  }
  // Actualizar un pais existente
  @PutMapping("/{id}")
  public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais paisDetails) {
    Optional<Pais> pais = paisService.getPaisById(id);
    if (pais.isPresent()) {
      Pais updatedPais = pais.get();
      updatedPais.setNombre(paisDetails.getNombre());
      return ResponseEntity.ok(paisService.savePais(updatedPais));
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  // Eliminar un pais
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePais(@PathVariable Long id) {
    Optional<Pais> pais = paisService.getPaisById(id);
    if (pais.isPresent()) {
      paisService.deletePais(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
}
