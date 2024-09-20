package com.stylo.store.controllers;

import com.stylo.store.models.Almacen;
import com.stylo.store.services.AlmacenService;

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

@RestController
@RequestMapping("/api/almacen")
public class AlmacenController {
  @Autowired
  private AlmacenService almacenService;
  
  // Obtener todos los almacenes
  @GetMapping
  public List<Almacen> getAllAlmacenes(){
    return almacenService.getAllAlmacenes();
  }

  // Obtener un almacen por ID
  @GetMapping("/{id}")
  public ResponseEntity<Almacen> getAlmacenById(@PathVariable Long id){
    Optional<Almacen> almacen = almacenService.getAlmacenById(id);
    return almacen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear un nuevo almacen
  @PostMapping
  public Almacen createAlmacen(@RequestBody Almacen almacen){
    return almacenService.saveAlmacen(almacen);
  }

  // Actualizar un almacen existente
  @PutMapping("/{id}")
  public ResponseEntity<Almacen> updateAlmacen(@PathVariable Long id, @RequestBody Almacen almacenDetails){
    Optional<Almacen> almacen = almacenService.getAlmacenById(id);
    if(almacen.isPresent()){
      Almacen updatedAlmacen = almacen.get();
      updatedAlmacen.setNombre(almacenDetails.getNombre());
      return ResponseEntity.ok(almacenService.saveAlmacen(updatedAlmacen));
    }else{
      return ResponseEntity.notFound().build();
    }
  }

  // Eliminar un almacen
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAlmacen(@PathVariable Long id){
    almacenService.deleteAlmacen(id);
    return ResponseEntity.noContent().build();
  }

}
