package com.stylo.store.repositories;

import com.stylo.store.models.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Long> {
    Optional<Talla> findByNombre(String nombre);
}
