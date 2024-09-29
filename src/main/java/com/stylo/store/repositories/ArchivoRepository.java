// ArchivoRepository.java
package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stylo.store.models.Archivo;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Long> {
    // Puedes definir métodos personalizados aquí si es necesario
}
