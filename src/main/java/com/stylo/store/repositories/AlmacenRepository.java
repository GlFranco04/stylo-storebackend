package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long> {
  // Métodos personalizados si se necesitan
}