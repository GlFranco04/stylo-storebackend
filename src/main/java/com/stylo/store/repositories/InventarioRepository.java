package com.stylo.store.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Inventario;
import com.stylo.store.models.Sucursal;
import com.stylo.store.models.DetalleProducto;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    // Método para encontrar el inventario por sucursal y detalle del producto
    Optional<Inventario> findBySucursalAndDetalleProducto(Sucursal sucursal, DetalleProducto detalleProducto);
}
