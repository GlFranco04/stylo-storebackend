package com.stylo.store.services;

import com.stylo.store.models.Proveedor;
import com.stylo.store.repositories.ProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    public List<Proveedor> obtenerProveedores() {
        return proveedorRepository.findAll();
    }

    // Obtener proveedor por ID
    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    // Crear o actualizar un nuevo proveedor
    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Eliminar un proveedor por ID
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
