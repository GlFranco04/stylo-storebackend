package com.stylo.store.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylo.store.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {
    Optional<Proveedor> findByNombre(String nombre);
}
