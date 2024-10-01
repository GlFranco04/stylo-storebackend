// InventarioService.java
package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Inventario;
import com.stylo.store.models.Sucursal;
import com.stylo.store.models.DetalleProducto;
import com.stylo.store.repositories.InventarioRepository;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    // Obtener todos los inventarios
    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    // Obtener inventario por ID
    public Optional<Inventario> getInventarioById(Long id){
        return inventarioRepository.findById(id);
    }

    // Guardar o actualizar inventario
    public Inventario saveInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    // Eliminar un inventario
    public void deleteInventario(Long id) {
        inventarioRepository.deleteById(id);
    }

    // Obtener inventario por sucursal y detalle producto
    public Optional<Inventario> findInventarioBySucursalAndDetalleProducto(Sucursal sucursal, DetalleProducto detalleProducto) {
        return inventarioRepository.findBySucursalAndDetalleProducto(sucursal, detalleProducto);
    }
}
