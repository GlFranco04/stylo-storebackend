package com.stylo.store.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
  // Medotodos personalizados si se necesitan
  Optional<Rol> findByNombre(String nombre);

}
