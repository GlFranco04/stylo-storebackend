package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.DetalleCompra;
import com.stylo.store.repositories.DetalleCompraRepository;

@Service
public class DetalleCompraService {
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    // Obtener todos los detalles de venta
    public List<DetalleCompra> obtenerTodosLosDetallesCompra() {
        return detalleCompraRepository.findAll();
    }

    // Obtener un detalle de venta por ID
    public Optional<DetalleCompra> obtenerDetalleCompraPorId(Long id) {
        return detalleCompraRepository.findById(id);
    }

    // Crear o actualizar un nuevo detalle de venta
    public DetalleCompra saveDetalleCompra(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    // Eliminar un detalle de venta
    public void eliminarDetalleCompra(Long id) {
        detalleCompraRepository.deleteById(id);
    }
}
