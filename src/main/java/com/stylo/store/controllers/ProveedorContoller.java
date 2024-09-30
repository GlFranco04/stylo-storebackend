package com.stylo.store.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.stylo.store.models.Proveedor;
import com.stylo.store.services.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorContoller {
    @Autowired
    private ProveedorService proveedorService;

    // Obtener todos los proveedores
    @GetMapping
    public List<Proveedor> getAllProveedores(){
        return proveedorService.obtenerProveedores();
    }

    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorByIdEntity(@PathVariable Long id){
        Optional<Proveedor> proveedor = proveedorService.obtenerProveedorPorId(id);
        return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo proveedor
    @PostMapping
    public Proveedor crearPais(@RequestBody Proveedor proveedor){
        return proveedorService.saveProveedor(proveedor);
    }

    // Actualizar un proveedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorDetails){
        Optional<Proveedor> proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor.isPresent()){
            Proveedor updatedProveedor = proveedor.get();
            updatedProveedor.setNombre(proveedorDetails.getNombre());
      return ResponseEntity.ok(proveedorService.saveProveedor(updatedProveedor));
    } else {
      return ResponseEntity.notFound().build();
        }
    }

}
