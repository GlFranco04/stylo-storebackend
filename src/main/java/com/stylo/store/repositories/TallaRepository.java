package com.stylo.store.repositories;

import com.stylo.store.models.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Long> {

    // Buscar tallas activas
    List<Talla> findByEstaActivo(boolean estaActivo);
    Optional<Talla> findByNombre(String nombre);

}
