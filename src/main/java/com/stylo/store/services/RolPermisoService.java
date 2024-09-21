package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.RolPermiso;
import com.stylo.store.repositories.RolPermisoRepository;

@Service
public class RolPermisoService {
  @Autowired
  RolPermisoRepository rolPermisoRepository;

  // Obtener todos los rolpermisos
  public List<RolPermiso> getAllRolpermisos() {
    return rolPermisoRepository.findAll();
  }

  // Obtener un rolpermiso por ID
  public Optional<RolPermiso> getRolPermisoById(Long id) {
    return rolPermisoRepository.findById(id);
  }

  // Guardar o actualizar un rolpermiso
  public RolPermiso saveRolPermiso(RolPermiso rolPermiso) {
    return rolPermisoRepository.save(rolPermiso);
  }

  // Eliminar un rolpermiso
  public void deleteRolPermiso(Long id) {
    rolPermisoRepository.deleteById(id);
  }
}
