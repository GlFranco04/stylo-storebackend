// DetalleCompraService.java

package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylo.store.models.DetalleCompra;
import com.stylo.store.models.Inventario;
import com.stylo.store.models.NotaCompra;
import com.stylo.store.repositories.DetalleCompraRepository;

@Service
public class DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;
    @Autowired
    private NotaCompraService notaCompraService;

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

@Transactional
public DetalleCompra saveDetalleCompra(DetalleCompra detalleCompra) {
    // Validar que NotaCompra y DetalleProducto no sean nulos
    if (detalleCompra.getNotaCompra() == null || detalleCompra.getNotaCompra().getId() == null) {
        throw new IllegalArgumentException("La NotaCompra no puede ser nula y debe tener un ID válido.");
    }
    if (detalleCompra.getDetalleProducto() == null || detalleCompra.getDetalleProducto().getId() == null) {
        throw new IllegalArgumentException("El DetalleProducto no puede ser nulo y debe tener un ID válido.");
    }

    // Recuperar la NotaCompra desde la base de datos para asegurarse de que todas las relaciones estén cargadas
    Optional<NotaCompra> optionalNotaCompra = notaCompraService.obtenerNotaCompraPorId(detalleCompra.getNotaCompra().getId());
    if (!optionalNotaCompra.isPresent()) {
        throw new IllegalArgumentException("NotaCompra no encontrada con el ID proporcionado: " + detalleCompra.getNotaCompra().getId());
    }

    NotaCompra notaCompra = optionalNotaCompra.get();
    
    // Validar que la NotaCompra tenga una Sucursal asociada
    if (notaCompra.getSucursal() == null) {
        throw new IllegalArgumentException("La Sucursal en la NotaCompra no puede ser nula.");
    }

    // Reasignar la NotaCompra cargada completamente a detalleCompra
    detalleCompra.setNotaCompra(notaCompra);

    // Guardar primero el detalleCompra para asegurar que todos los objetos estén persistidos
    DetalleCompra savedDetalleCompra = detalleCompraRepository.save(detalleCompra);

    // Buscar el inventario correspondiente al detalle del producto usando la sucursal de la nota de compra
    Optional<Inventario> optionalInventario = inventarioService
            .findInventarioBySucursalAndDetalleProducto(
                    savedDetalleCompra.getNotaCompra().getSucursal(),
                    savedDetalleCompra.getDetalleProducto());

    Inventario inventario;
    if (optionalInventario.isPresent()) {
        inventario = optionalInventario.get();
    } else {
        // Si el inventario no existe, crearlo
        inventario = new Inventario();
        inventario.setSucursal(savedDetalleCompra.getNotaCompra().getSucursal());
        inventario.setDetalleProducto(savedDetalleCompra.getDetalleProducto());
        inventario.setInventarioDisponible(0L); // O algún valor inicial
    }

    // Sumar la cantidad comprada del inventario disponible
    Long nuevaCantidadDisponible = inventario.getInventarioDisponible() + savedDetalleCompra.getCantidad();
    inventario.setInventarioDisponible(nuevaCantidadDisponible);

    // Guardar el inventario actualizado
    inventarioService.saveInventario(inventario);

    return savedDetalleCompra;
    }
    

    // Eliminar un detalle de compra
    public void eliminarDetalleCompra(Long id) {
        detalleCompraRepository.deleteById(id);
    }
}
