package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.UsuarioSucursal;
import com.stylo.store.repositories.UsuarioSucursalRepository;

@Service
public class UsuarioSucursalService {
  @Autowired
  private UsuarioSucursalRepository usuarioSucursalRepository;

  // Obtener todos los usuariosSucursales
  public List<UsuarioSucursal> getAllUsuarioSucursales() {
    return usuarioSucursalRepository.findAll();
  }

  // Obtener un usuarioSucursal por ID
  public Optional<UsuarioSucursal> getUsuarioSucursalById(Long id) {
    return usuarioSucursalRepository.findById(id);
  }

  // Guardar o actualizar un usuarioSucursal
  public UsuarioSucursal saveUsuarioSucursal(UsuarioSucursal usuarioSucursal) {
    return usuarioSucursalRepository.save(usuarioSucursal);
  }

  // Eliminar un usuarioSucursal
  public void deleteUsuarioSucursal(Long id) {
    usuarioSucursalRepository.deleteById(id);
  }
  
}
