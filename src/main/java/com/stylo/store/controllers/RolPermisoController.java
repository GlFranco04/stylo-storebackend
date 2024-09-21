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

import com.stylo.store.models.RolPermiso;
import com.stylo.store.services.RolPermisoService;;

@RestController
@RequestMapping("/api/rol-permiso")
public class RolPermisoController {
  @Autowired
  private RolPermisoService rolPermisoService;

  // Obtener todos los rolpermisos
  @GetMapping
  public List<RolPermiso> getAllRolPermisos() {
    return rolPermisoService.getAllRolpermisos();
  }

  // Obtener un rolPermiso por ID
  @GetMapping("/{id}")
  public Optional<RolPermiso> getRolPermisoById(@PathVariable Long id) {
    return rolPermisoService.getRolPermisoById(id);
  }

  // Crear un nuevo rolPermiso
  @PostMapping
  public RolPermiso createRolPermiso(@RequestBody RolPermiso rolPermiso) {
    return rolPermisoService.saveRolPermiso(rolPermiso);
  }

  // Actualizar un rolPermiso existente
  @PutMapping("/{id}")
  public ResponseEntity<RolPermiso> updateRolPermiso(@PathVariable Long id, @RequestBody RolPermiso rolPermiso){
    Optional<RolPermiso> rolPermisoOptional = rolPermisoService.getRolPermisoById(id);
    if(rolPermisoOptional.isPresent()){
      RolPermiso updatedRolPermiso = rolPermisoOptional.get();
      updatedRolPermiso.setFechaAsignacion(rolPermiso.getFechaAsignacion());
      return ResponseEntity.ok(rolPermisoService.saveRolPermiso(updatedRolPermiso));
    }else{
      return ResponseEntity.notFound().build();
    }
  }

  // Eliminar un rolpermiso existente
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRolPermiso(@PathVariable Long id){
    Optional<RolPermiso> rolpermisoOptional = rolPermisoService.getRolPermisoById(id);
    if(rolpermisoOptional.isPresent()){
      rolPermisoService.deleteRolPermiso(id);
      return ResponseEntity.noContent().build();
    }else{
      return ResponseEntity.notFound().build();
    }
  }

}
