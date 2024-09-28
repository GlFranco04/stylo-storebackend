package com.stylo.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Long>{
  Optional<Ciudad> findByNombre(String nombre);
  List<Ciudad> findByPaisId(Long paisId);
}
