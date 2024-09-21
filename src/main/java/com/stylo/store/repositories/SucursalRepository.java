package com.stylo.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

  // Buscar sucursales activas
  List<Sucursal> findByEstaActivo(boolean estaActivo);
  Optional<Sucursal> findByNombre(String nombre);

}