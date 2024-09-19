package com.stylo.store.repositories;

import com.stylo.store.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Métodos personalizados si se necesitan
}
