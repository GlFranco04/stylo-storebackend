package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Pais;
import com.stylo.store.repositories.PaisRepository;

@Service
public class PaisService {
  @Autowired
  private PaisRepository paisRepository;

  // Obtener todos los paises
  public List<Pais> getAllPaises() {
    return paisRepository.findAll();
  }

  // Obtener un país por ID
  public Optional<Pais> getPaisById(Long id) {
    return paisRepository.findById(id);
  }

  // Guardar o actualizar un país
  public Pais savePais(Pais pais) {
    return paisRepository.save(pais);
  }

  // Eliminar un país
  public void deletePais(Long id) {
    paisRepository.deleteById(id);
  }
}
