package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Ciudad;
import com.stylo.store.repositories.CiudadRepository;

@Service
public class CiudadService {
  @Autowired
  private CiudadRepository ciudadRepository;

  // Obtener todas las ciudades
  public List<Ciudad> getAllCiudades() {
    return ciudadRepository.findAll();
  }

  // Obtener una ciudad por ID
  public Optional<Ciudad> getCiudadById(Long id) {
    return ciudadRepository.findById(id);
  }

  // Guardar o actualizar una ciudad
  public Ciudad saveCiudad(Ciudad ciudad) {
    return ciudadRepository.save(ciudad);
  }

  // Eliminar una ciudad
  public void deleteCiudad(Long id) {
    ciudadRepository.deleteById(id);
  }
}
