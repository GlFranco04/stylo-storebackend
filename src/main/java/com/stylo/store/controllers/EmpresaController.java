package com.stylo.store.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylo.store.models.Empresa;
import com.stylo.store.services.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
  @Autowired
  private EmpresaService empresaService;

  // Obtener todas las empresas
  @PreAuthorize("hasRole('SuperUsuario') or hasRole('Vendedor')")
  @GetMapping
  public List<Empresa> getAllEmpresas() {
    return empresaService.getAllEmpresas();
  }

  // Obtener una empresa por ID
  @GetMapping("/{id}")
  public ResponseEntity<Empresa> getEmpresasById(@PathVariable Long id){
    Optional<Empresa> empresa = empresaService.getEmpresaById(id);
    return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }  

  // Crear una nueva empresa
  @PostMapping
  @PreAuthorize("hasAuthority('crear_empresa')")
  public Empresa createEmpresa(@RequestBody Empresa empresa) {
    return empresaService.saveEmpresa(empresa);
  }

  // Actualizar una empresa existente
  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('editar_empresa')")
  public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresaDetails) {
    Optional<Empresa> empresa = empresaService.getEmpresaById(id);
    if (empresa.isPresent()) {
      Empresa updatedEmpresa = empresa.get();
      updatedEmpresa.setNombre(empresaDetails.getNombre());
      updatedEmpresa.setCorreo(empresaDetails.getCorreo());
      updatedEmpresa.setTelefono(empresaDetails.getTelefono());
      updatedEmpresa.setPropietario(empresaDetails.getPropietario());
      return ResponseEntity.ok(empresaService.saveEmpresa(updatedEmpresa));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Eliminar una empresa existente
  @DeleteMapping("/{id}")
  @PreAuthorize("hasAuthority('eliminar_empresa')")
  public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
    Optional<Empresa> empresa =empresaService.getEmpresaById(id);
    if (empresa.isPresent()) {
      empresaService.deleteEmpresa(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
