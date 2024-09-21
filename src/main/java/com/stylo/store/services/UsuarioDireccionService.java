package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.UsuarioDireccion;
import com.stylo.store.repositories.UsuarioDireccionRepository;

@Service
public class UsuarioDireccionService {
  @Autowired
  private UsuarioDireccionRepository usuarioDireccionRepository;

  // Obtener todos los usuarioDireccion
  public List<UsuarioDireccion> getAllUsuarioDirecciones() {
    return usuarioDireccionRepository.findAll();
  }

  // Obtener un usuarioDireccion por ID
  public Optional<UsuarioDireccion> getUsuarioDireccionById(Long id) {
    return usuarioDireccionRepository.findById(id);
  }

  // Guardar o actualizar un usuarioDireccion
  public UsuarioDireccion saveUsuarioDireccion(UsuarioDireccion usuarioDireccion) {
    return usuarioDireccionRepository.save(usuarioDireccion);
  }

  // Eliminar un usuarioDireccion
  public void deleteUsuarioDireccion(Long id) {
    usuarioDireccionRepository.deleteById(id);
  }
}
