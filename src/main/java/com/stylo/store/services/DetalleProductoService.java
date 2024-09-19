package com.stylo.store.services;

import com.stylo.store.models.DetalleProducto;
import com.stylo.store.repositories.DetalleProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleProductoService {

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    // Obtener todos los detalles de productos
    public List<DetalleProducto> getAllDetalleProductos() {
        return detalleProductoRepository.findAll();
    }

    // Obtener un detalle de producto por ID
    public Optional<DetalleProducto> getDetalleProductoById(Long id) {
        return detalleProductoRepository.findById(id);
    }

    // Guardar o actualizar un detalle de producto
    public DetalleProducto saveDetalleProducto(DetalleProducto detalleProducto) {
        return detalleProductoRepository.save(detalleProducto);
    }

    // Eliminar un detalle de producto
    public void deleteDetalleProducto(Long id) {
        detalleProductoRepository.deleteById(id);
    }
}
