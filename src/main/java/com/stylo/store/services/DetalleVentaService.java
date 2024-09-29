package com.stylo.store.services;

import com.stylo.store.models.DetalleVenta;
import com.stylo.store.repositories.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    // Obtener todos los detalles de venta
    public List<DetalleVenta> obtenerTodosLosDetallesVenta() {
        return detalleVentaRepository.findAll();
    }

    // Obtener un detalle de venta por ID
    public Optional<DetalleVenta> obtenerDetalleVentaPorId(Long id) {
        return detalleVentaRepository.findById(id);
    }

    // Crear o actualizar un nuevo detalle de venta
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    // Eliminar un detalle de venta
    public void eliminarDetalleVenta(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
