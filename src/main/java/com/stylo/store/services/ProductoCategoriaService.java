package com.stylo.store.services;

import com.stylo.store.models.ProductoCategoria;
import com.stylo.store.repositories.ProductoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoCategoriaService {

    @Autowired
    private ProductoCategoriaRepository productoCategoriaRepository;

    // Obtener todas las relaciones producto-categoría
    public List<ProductoCategoria> getAllProductoCategorias() {
        return productoCategoriaRepository.findAll();
    }

    public List<ProductoCategoria> obtenerCategoriasPorProducto(Long productoId) {
        return productoCategoriaRepository.findByProductoId(productoId);
    }

    // Obtener una relación producto-categoría por ID
    public Optional<ProductoCategoria> getProductoCategoriaById(Long id) {
        return productoCategoriaRepository.findById(id);
    }

    // Guardar o actualizar una relación producto-categoría
    public ProductoCategoria saveProductoCategoria(ProductoCategoria productoCategoria) {
        return productoCategoriaRepository.save(productoCategoria);
    }

    // Eliminar una relación producto-categoría por ID
    public void deleteProductoCategoria(Long id) {
        productoCategoriaRepository.deleteById(id);
    }
}
