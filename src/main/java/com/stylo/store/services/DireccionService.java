package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Direccion;
import com.stylo.store.repositories.DireccionRepository;

@Service
public class DireccionService {
  @Autowired
  private DireccionRepository direccionRepository;

  // Obtener todas las direcciones
  public List<Direccion> getAllDirecciones() {
    return direccionRepository.findAll();
  }

  // Obtener una dirección por ID
  public Optional<Direccion> getDireccionById(Long id) {
    return direccionRepository.findById(id);
  }

  // Guardar o actualizar una dirección
  public Direccion saveDireccion(Direccion direccion) {
    return direccionRepository.save(direccion);
  }

  public List<Direccion> obtenerDireccionesNoAsignadas() {
    return direccionRepository.findBySucursalIsNullAndUsuarioIsNull();
  }

  // Eliminar una dirección
  public void deleteDireccion(Long id) {
    direccionRepository.deleteById(id);
  }
}