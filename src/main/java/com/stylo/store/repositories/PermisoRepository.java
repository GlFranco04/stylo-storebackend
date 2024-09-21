package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso,Long> {
  // Métodos personalizados si se necesitan
}
