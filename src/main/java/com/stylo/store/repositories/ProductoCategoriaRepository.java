package com.stylo.store.repositories;

import com.stylo.store.models.ProductoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCategoriaRepository extends JpaRepository<ProductoCategoria, Long> {
    // Métodos personalizados si se necesitan
}
