// ArchivoProductoRepository.java
package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stylo.store.models.ArchivoProducto;

@Repository
public interface ArchivoProductoRepository extends JpaRepository<ArchivoProducto, Long> {
    // Puedes definir métodos personalizados aquí si es necesario
}
