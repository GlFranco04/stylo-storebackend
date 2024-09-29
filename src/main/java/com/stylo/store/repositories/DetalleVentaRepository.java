package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylo.store.models.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long>{
  
}
