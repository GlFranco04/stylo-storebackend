// ArchivoProductoService.java
package com.stylo.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.ArchivoProducto;
import com.stylo.store.repositories.ArchivoProductoRepository;

import java.util.Optional;

@Service
public class ArchivoProductoService {

    @Autowired
    private ArchivoProductoRepository archivoProductoRepository;

    public void guardarArchivoProducto(ArchivoProducto archivoProducto) {
        archivoProductoRepository.save(archivoProducto);
    }

    public Optional<ArchivoProducto> obtenerArchivoProductoPorId(Long id) {
        return archivoProductoRepository.findById(id);
    }

    public void eliminarArchivoProducto(Long id) {
        archivoProductoRepository.deleteById(id);
    }
}
