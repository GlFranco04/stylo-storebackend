package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.NotaCompra;
import com.stylo.store.models.DetalleCompra;
import com.stylo.store.models.Inventario;
import com.stylo.store.repositories.NotaCompraRepository;
import com.stylo.store.services.InventarioService;

@Service
public class NotaCompraService {
    @Autowired
    private NotaCompraRepository notaCompraRepository;

    @Autowired
    private InventarioService inventarioService;

    // Obtener todas las notas de venta
    public List<NotaCompra> obtenerTodasLasNotasCompra() {
        return notaCompraRepository.findAll();
    }

    // Obtener una nota de venta por ID
    public Optional<NotaCompra> obtenerNotaCompraPorId(Long id) {
        return notaCompraRepository.findById(id);
    }

    // Crear o actualizar una nueva nota de venta
    public NotaCompra saveNotaCompra(NotaCompra notaCompra) {
        // Guardar la nota de compra
        NotaCompra savedNotaCompra = notaCompraRepository.save(notaCompra);

        // Iterar sobre los detalles de compra para actualizar el inventario disponible
        for (DetalleCompra detalleCompra : savedNotaCompra.getDetalleCompras()) {
            // Obtener el inventario correspondiente al detalle del producto
            Optional<Inventario> optionalInventario = inventarioService
                    .findInventarioBySucursalAndDetalleProducto(savedNotaCompra.getSucursal(), detalleCompra.getDetalleProducto());

            if (optionalInventario.isPresent()) {
                Inventario inventario = optionalInventario.get();
                // Restar la cantidad comprada al inventario disponible
                Long nuevaCantidadDisponible = inventario.getInventarioDisponible() - detalleCompra.getCantidad();
                inventario.setInventarioDisponible(nuevaCantidadDisponible);

                // Guardar el inventario actualizado
                inventarioService.saveInventario(inventario);
            }
        }

        return savedNotaCompra;
    }

    // Eliminar una nota de venta
    public void eliminarNotaCompra(Long id) {
        notaCompraRepository.deleteById(id);
    }
}
