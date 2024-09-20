package com.stylo.store.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Almacen;
import com.stylo.store.repositories.AlmacenRepository;

@Service
public class AlmacenService {
  @Autowired
  private AlmacenRepository almacenRepository;

  // Obtener todas las tallas
  public List<Almacen> getAllAlmacenes(){
    return almacenRepository.findAll();
  }
  // Obtener un almacen por id
  public Optional<Almacen> getAlmacenById(Long id){
    return almacenRepository.findById(id);
  }

  // Guardar o actualizar un almacen
  public Almacen saveAlmacen(Almacen almacen){
    return almacenRepository.save(almacen);
  }
  // Eliminar un almacen
  public void deleteAlmacen(Long id){
    almacenRepository.deleteById(id);
  }
}
