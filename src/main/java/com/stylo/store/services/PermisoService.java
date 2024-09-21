package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Permiso;
import com.stylo.store.repositories.PermisoRepository;

@Service
public class PermisoService {
  @Autowired
  private PermisoRepository permisoRepository;

  // Obtener todos los permisos
  public List<Permiso> getAllPermisos() {
    return permisoRepository.findAll();
  }

  // Obtener un permiso por ID
  public Optional<Permiso> getPermisoById(Long id) {
    return permisoRepository.findById(id);
  }

  // Guardar un nuevo permiso
  public Permiso savePermiso(Permiso permiso) {
    return permisoRepository.save(permiso);
  }

  // Eliminar un permiso
  public void deletePermiso(Long id) {
    permisoRepository.deleteById(id);
  }
}
