package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Sucursal;
import com.stylo.store.repositories.SucursalRepository;

@Service
public class SucursalService {
  @Autowired
  private SucursalRepository sucursalRepository;

  // Obtener todas las sucursales activas
  public List<Sucursal> getAllSucursales(){
    return sucursalRepository.findAll();
  }
  // Obtener una sucursal por ID
  public Optional<Sucursal> getSucursalById(Long id){
    return sucursalRepository.findById(id);
  }
  // Guardar o actualizar una sucursal
  public Sucursal saveSucursal(Sucursal sucursal){
    return sucursalRepository.save(sucursal);
  }

  // Cambiar estado de sucursal
  public void toggleSucursalStatus(Long id){
    Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
    if(sucursalOptional.isPresent()){
      Sucursal sucursal = sucursalOptional.get();
      sucursal.setEstaActivo(!sucursal.isEstaActivo());
      sucursalRepository.save(sucursal);
    }
  }

}
