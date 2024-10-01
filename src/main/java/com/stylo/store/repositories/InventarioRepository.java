package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long> {
  // Metodos personalizados si se necesitan
}
