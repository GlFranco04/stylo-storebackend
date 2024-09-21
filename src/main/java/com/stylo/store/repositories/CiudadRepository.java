package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Long>{
  
}
