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

  // Método para obtener las ciudades por el ID del país
  public List<Ciudad> obtenerCiudadesPorPais(Long paisId) {
    return ciudadRepository.findByPaisId(paisId);
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
