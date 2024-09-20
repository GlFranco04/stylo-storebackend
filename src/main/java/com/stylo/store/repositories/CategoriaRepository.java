package com.stylo.store.repositories;

import com.stylo.store.models.Categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Métodos personalizados si se necesitan
    
    // Buscar productos activos
    List<Categoria> findByEstaActivo(boolean estaActivo);
}
