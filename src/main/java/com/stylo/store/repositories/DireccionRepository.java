package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Long>{
  // Metodos personalizados si se necesitan
}
