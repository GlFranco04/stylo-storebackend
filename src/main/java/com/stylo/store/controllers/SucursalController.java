package com.stylo.store.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylo.store.models.Sucursal;
import com.stylo.store.services.SucursalService;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {
  @Autowired
  private SucursalService sucursalService;
  
  // Obtener todas las sucursales
  @GetMapping
  public List<Sucursal> getAllSucursales(){
    return sucursalService.getAllActiveSucursales();
  }

  // Obtener una sucursal por ID
  @GetMapping("/{id}")
  public ResponseEntity<Sucursal> getSucursalById(@PathVariable Long id){
    Optional<Sucursal> sucursal = sucursalService.getSucursalById(id);
    return sucursal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear una nueva sucursal
  @PostMapping
  public Sucursal createSucursal(@RequestBody Sucursal sucursal){
    return sucursalService.saveSucursal(sucursal);
  }

  // Actualizar una sucursal existente
  @PutMapping("/{id}")
  public ResponseEntity<Sucursal> updateSucursal(@PathVariable Long id, @RequestBody Sucursal sucursalDetails){
    Optional<Sucursal> sucursal = sucursalService.getSucursalById(id);
    if(sucursal.isPresent()){
      Sucursal updatedSucursal = sucursal.get();
      updatedSucursal.setNombre(sucursalDetails.getNombre());
      updatedSucursal.setEstaActivo(sucursalDetails.isEstaActivo());
      return ResponseEntity.ok(sucursalService.saveSucursal(updatedSucursal));
    }else{
      return ResponseEntity.notFound().build();
    }
  }
  
  // Desactivar una sucursal (soft delete)
  @PatchMapping("/{id}")
  public ResponseEntity<Void> deactivateSucursal(@PathVariable Long id){
    sucursalService.toggleSucursalStatus(id);
    return ResponseEntity.noContent().build();
  }
  
}
