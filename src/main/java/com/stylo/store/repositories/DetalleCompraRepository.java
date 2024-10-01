package com.stylo.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylo.store.models.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra,Long>{
  List<DetalleCompra> findByNotaCompraId(Long notaCompraId);
}
