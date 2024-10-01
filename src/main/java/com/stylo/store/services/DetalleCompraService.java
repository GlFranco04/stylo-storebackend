// DetalleCompraService.java

package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylo.store.models.DetalleCompra;
import com.stylo.store.models.Inventario;
import com.stylo.store.repositories.DetalleCompraRepository;

@Service
public class DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private InventarioService inventarioService;

    // Obtener todos los detalles de compra
    public List<DetalleCompra> obtenerTodosLosDetallesCompra() {
        return detalleCompraRepository.findAll();
    }

    // Obtener un detalle de compra por ID
    public Optional<DetalleCompra> obtenerDetalleCompraPorId(Long id) {
        return detalleCompraRepository.findById(id);
    }

    // Crear o actualizar un nuevo detalle de compra
    @Transactional
    public DetalleCompra saveDetalleCompra(DetalleCompra detalleCompra) {
        // Validar que NotaCompra y DetalleProducto no sean nulos
        if (detalleCompra.getNotaCompra() == null) {
            throw new IllegalArgumentException("La NotaCompra no puede ser nula.");
        }
        if (detalleCompra.getDetalleProducto() == null) {
            throw new IllegalArgumentException("El DetalleProducto no puede ser nulo.");
        }
    
        // Validar que la NotaCompra tenga una Sucursal asociada
        if (detalleCompra.getNotaCompra().getSucursal() == null) {
            throw new IllegalArgumentException("La Sucursal en la NotaCompra no puede ser nula.");
        }
    
        // Guardar primero el detalleCompra para asegurar que todos los objetos estén persistidos
        DetalleCompra savedDetalleCompra = detalleCompraRepository.save(detalleCompra);
    
        // Buscar el inventario correspondiente al detalle del producto usando la sucursal de la nota de compra
        Optional<Inventario> optionalInventario = inventarioService
                .findInventarioBySucursalAndDetalleProducto(
                        savedDetalleCompra.getNotaCompra().getSucursal(),
                        savedDetalleCompra.getDetalleProducto());
    
        if (optionalInventario.isPresent()) {
            Inventario inventario = optionalInventario.get();
    
            // Restar la cantidad comprada del inventario disponible
            Long nuevaCantidadDisponible = inventario.getInventarioDisponible() - savedDetalleCompra.getCantidad();
            if (nuevaCantidadDisponible < 0) {
                throw new IllegalArgumentException("Inventario insuficiente para el producto: " + savedDetalleCompra.getDetalleProducto().getId());
            }
            inventario.setInventarioDisponible(nuevaCantidadDisponible);
    
            // Guardar el inventario actualizado
            inventarioService.saveInventario(inventario);
        } else {
            throw new IllegalArgumentException("Inventario no encontrado para el producto: " + savedDetalleCompra.getDetalleProducto().getId());
        }
    
        return savedDetalleCompra;
    }
    

    // Eliminar un detalle de compra
    public void eliminarDetalleCompra(Long id) {
        detalleCompraRepository.deleteById(id);
    }
}
