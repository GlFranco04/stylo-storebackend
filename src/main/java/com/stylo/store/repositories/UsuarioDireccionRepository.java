package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.UsuarioDireccion;

@Repository
public interface UsuarioDireccionRepository extends JpaRepository<UsuarioDireccion,Long>{
  // Metodos personzalidos si se necesitan}
  
}
