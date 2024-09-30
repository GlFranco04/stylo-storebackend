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

import com.stylo.store.models.UsuarioSucursal;
import com.stylo.store.services.UsuarioSucursalService;

@RestController
@RequestMapping("/api/usuario-sucursal")
@CrossOrigin(origins = "https://stylo-store-git-master-gabriels-projects-9c5cda58.vercel.app")
public class UsuarioSucursalController {
  @Autowired
  private UsuarioSucursalService usuarioSucursalService;

  // Obtener todos los usuarioSucursal
  @GetMapping
  public List<UsuarioSucursal> getAllUsuarioSucursales() {
    return usuarioSucursalService.getAllUsuarioSucursales();
  }
  // Obtener un usuarioSucursal por ID
  @GetMapping("/{id}")
  public Optional<UsuarioSucursal> getUsuarioSucursalById(@PathVariable Long id) {
    return usuarioSucursalService.getUsuarioSucursalById(id);
  }

  // Crear un nuevo usuarioSucursal
  @PostMapping
  public UsuarioSucursal createUsuarioSucursal(@RequestBody UsuarioSucursal usuarioSucursal){
    return usuarioSucursalService.saveUsuarioSucursal(usuarioSucursal);
  }

  // Actualizar un usuarioSucursal existente
  @PutMapping("/{id}")
  public ResponseEntity<UsuarioSucursal> updateUsuarioSucursal(@PathVariable Long id, @RequestBody UsuarioSucursal usuarioSucursal){
    Optional<UsuarioSucursal> usuarioSucursalOptional = usuarioSucursalService.getUsuarioSucursalById(id);
    if(usuarioSucursalOptional.isPresent()){
      UsuarioSucursal updatedUsuarioSucursal = usuarioSucursalOptional.get();
      updatedUsuarioSucursal.setFechaInicio(usuarioSucursal.getFechaInicio());
      return ResponseEntity.ok(usuarioSucursalService.saveUsuarioSucursal(updatedUsuarioSucursal));
    }else{
      return ResponseEntity.notFound().build();
    }
  }

  //  Eliminar un usuarioSucursal
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUsuarioSucursal(@PathVariable Long id){
    Optional<UsuarioSucursal> usuarioSucursal = usuarioSucursalService.getUsuarioSucursalById(id);
    if(usuarioSucursal.isPresent()){
      usuarioSucursalService.deleteUsuarioSucursal(id);
      return ResponseEntity.noContent().build();
    }else{
      return ResponseEntity.notFound().build();
    }
  }
}
