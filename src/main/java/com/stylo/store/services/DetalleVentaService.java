package com.stylo.store.services;

import com.stylo.store.models.DetalleVenta;
import com.stylo.store.models.Inventario;
import com.stylo.store.models.NotaVenta;
import com.stylo.store.repositories.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    @Autowired
    private NotaVentaService notaVentaService;
    @Autowired
    private InventarioService inventarioService;

    // Obtener todos los detalles de venta
    public List<DetalleVenta> obtenerTodosLosDetallesVenta() {
        return detalleVentaRepository.findAll();
    }

    // Obtener un detalle de venta por ID
    public Optional<DetalleVenta> obtenerDetalleVentaPorId(Long id) {
        return detalleVentaRepository.findById(id);
    }

    @Transactional
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
        // Validar que NotaCompra y DetalleProducto no sean nulos
        if (detalleVenta.getNotaVenta() == null || detalleVenta.getNotaVenta().getId() == null) {
            throw new IllegalArgumentException("La NotaVenta no puede ser nula y debe tener un ID válido.");
        }
        if (detalleVenta.getDetalleProducto() == null || detalleVenta.getDetalleProducto().getId() == null) {
            throw new IllegalArgumentException("El DetalleProducto no puede ser nulo y debe tener un ID válido.");
        }

        // Recuperar la NotaCompra desde la base de datos para asegurarse de que todas las relaciones estén cargadas
        Optional<NotaVenta> optionalNotaVenta = notaVentaService.obtenerNotaVentaPorId(detalleVenta.getNotaVenta().getId());
        if (!optionalNotaVenta.isPresent()) {
            throw new IllegalArgumentException("NotaVenta no encontrada con el ID proporcionado: " + detalleVenta.getNotaVenta().getId());
        }

        NotaVenta notaVenta = optionalNotaVenta.get();
        
        // Validar que la NotaVenta tenga una Sucursal asociada
        if (notaVenta.getSucursal() == null) {
            throw new IllegalArgumentException("La Sucursal en la NotaVenta no puede ser nula.");
        }

        // Reasignar la NotaCompra cargada completamente a detalleCompra
        detalleVenta.setNotaVenta(notaVenta);

        // Guardar primero el detalleCompra para asegurar que todos los objetos estén persistidos
        DetalleVenta savedDetalleVenta = detalleVentaRepository.save(detalleVenta);

        // Buscar el inventario correspondiente al detalle del producto usando la sucursal de la nota de compra
        Optional<Inventario> optionalInventario = inventarioService.findInventarioBySucursalAndDetalleProducto(
                        savedDetalleVenta.getNotaVenta().getSucursal(),
                        savedDetalleVenta.getDetalleProducto());

        Inventario inventario;
        if (optionalInventario.isPresent()) {
            inventario = optionalInventario.get();
        } else {
            throw new IllegalArgumentException("Inventario no existente");
        }

        // Restar la cantidad comprada del inventario disponible
        Long nuevaCantidadDisponible = inventario.getInventarioDisponible() - savedDetalleVenta.getCantidad();
        inventario.setInventarioDisponible(nuevaCantidadDisponible);
        if (nuevaCantidadDisponible < 0 ) {
            throw new IllegalArgumentException("Inventario insuficiente para el producto: " + savedDetalleVenta.getDetalleProducto().getId());
        }
        // Guardar el inventario actualizado
        inventarioService.saveInventario(inventario);

        return savedDetalleVenta;
        }

    // Eliminar un detalle de venta
    public void eliminarDetalleVenta(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
