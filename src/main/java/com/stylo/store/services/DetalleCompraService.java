package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylo.store.models.DetalleCompra;
import com.stylo.store.models.Inventario;
import com.stylo.store.repositories.DetalleCompraRepository;
import com.stylo.store.services.InventarioService;

@Service
public class DetalleCompraService {
    
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private InventarioService inventarioService;

    // Obtener todos los detalles de venta
    public List<DetalleCompra> obtenerTodosLosDetallesCompra() {
        return detalleCompraRepository.findAll();
    }

    // Obtener un detalle de venta por ID
    public Optional<DetalleCompra> obtenerDetalleCompraPorId(Long id) {
        return detalleCompraRepository.findById(id);
    }

    // Crear o actualizar un nuevo detalle de venta
    @Transactional
    public DetalleCompra saveDetalleCompra(DetalleCompra detalleCompra) {
        // Obtener el inventario correspondiente al detalle del producto
        Optional<Inventario> optionalInventario = inventarioService
                .findInventarioBySucursalAndDetalleProducto(detalleCompra.getNotaCompra().getSucursal(), detalleCompra.getDetalleProducto());

        if (optionalInventario.isPresent()) {
            Inventario inventario = optionalInventario.get();

            // Restar la cantidad comprada del inventario disponible
            Long nuevaCantidadDisponible = inventario.getInventarioDisponible() - detalleCompra.getCantidad();
            if (nuevaCantidadDisponible < 0) {
                throw new IllegalArgumentException("Inventario insuficiente para el producto: " + detalleCompra.getDetalleProducto().getId());
            }
            inventario.setInventarioDisponible(nuevaCantidadDisponible);

            // Guardar el inventario actualizado
            inventarioService.saveInventario(inventario);
        } else {
            throw new IllegalArgumentException("Inventario no encontrado para el producto: " + detalleCompra.getDetalleProducto().getId());
        }

        // Guardar y devolver el detalle de compra
        return detalleCompraRepository.save(detalleCompra);
    }

    // Eliminar un detalle de venta
    public void eliminarDetalleCompra(Long id) {
        detalleCompraRepository.deleteById(id);
    }
}
