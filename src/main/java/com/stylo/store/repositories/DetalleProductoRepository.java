package com.stylo.store.repositories;

import com.stylo.store.models.DetalleProducto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Long> {
  Optional<DetalleProducto> findByColor(String color);
}
