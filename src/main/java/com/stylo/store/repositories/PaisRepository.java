package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Long>{
  
}
