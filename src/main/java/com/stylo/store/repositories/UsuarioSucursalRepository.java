package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.UsuarioSucursal;

@Repository
public interface UsuarioSucursalRepository extends JpaRepository<UsuarioSucursal,Long> {
  // Metodos personalizados si se necesitan
}
