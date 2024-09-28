package com.stylo.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Long>{
  // Metodos personalizados si se necesitan
  Optional<Direccion> findByNombre(String nombre);
  List<Direccion> findBySucursalIsNullAndUsuarioIsNull();
}
