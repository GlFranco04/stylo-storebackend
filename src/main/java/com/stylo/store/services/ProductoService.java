package com.stylo.store.services;

import com.stylo.store.models.Producto;
import com.stylo.store.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
  
    // Obtener todos los productos activos
    public List<Producto> getAllActiveProductos() {
        return productoRepository.findByEstaActivo(true);
    }

    // Obtener un producto por ID
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    // Guardar o actualizar un producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void toggleProductoStatus(Long id) {
      Optional<Producto> productoOptional = productoRepository.findById(id);
      if (productoOptional.isPresent()) {
          Producto producto = productoOptional.get();
          // Negar el estado actual de 'esta_activo'
          producto.setEstaActivo(!producto.isEstaActivo());
          productoRepository.save(producto);  // Guardar los cambios
      }
    }
}
