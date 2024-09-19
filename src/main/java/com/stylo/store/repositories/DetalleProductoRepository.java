package com.stylo.store.repositories;

import com.stylo.store.models.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Long> {
}
