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

import com.stylo.store.models.Inventario;
import com.stylo.store.services.InventarioService;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
  @Autowired
  private InventarioService inventarioService;

  // Obtener todos los inventario
  @GetMapping
  public List<Inventario> getAllInventarios(){
    return inventarioService.getAllInventarios();
  }

  // Obtener un inventario por ID
  @GetMapping("/{id}")
  public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id){
    Optional<Inventario> inventario = inventarioService.getInventarioById(id);
    return inventario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear un nuevo inventario
  @PostMapping
  public Inventario createInventario(@RequestBody Inventario inventario){
    return inventarioService.saveInventario(inventario);
  }

  // Actualizar un inventario existente
  @PutMapping("/{id}")
  public ResponseEntity<Inventario> updateInventario(@PathVariable Long id, @RequestBody Inventario inventarioDetails){
    Optional<Inventario> inventario = inventarioService.getInventarioById(id);
    if(inventario.isPresent()){
      Inventario updatedInventario = inventario.get();
      updatedInventario.setInventarioDisponible(inventarioDetails.getInventarioDisponible());
      return ResponseEntity.ok(inventarioService.saveInventario(updatedInventario));
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  // Eliminar un inventario
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteInventario(@PathVariable Long id){
    inventarioService.deleteInventario(id);
    return ResponseEntity.noContent().build();
  }
}
