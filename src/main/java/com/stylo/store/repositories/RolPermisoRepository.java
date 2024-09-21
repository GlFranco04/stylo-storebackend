package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.RolPermiso;

@Repository
public interface RolPermisoRepository extends JpaRepository<RolPermiso,Long> {
  // Métodos personalizados si se necesitan
}
