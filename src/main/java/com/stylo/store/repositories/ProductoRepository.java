package com.stylo.store.repositories;

import com.stylo.store.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Buscar productos activos
    List<Producto> findByEstaActivo(boolean estaActivo);
}