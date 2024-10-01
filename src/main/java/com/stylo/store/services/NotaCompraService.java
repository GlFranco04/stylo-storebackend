package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.NotaCompra;
import com.stylo.store.repositories.NotaCompraRepository;

@Service
public class NotaCompraService {
    @Autowired
    private NotaCompraRepository notaCompraRepository;

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
        return notaCompraRepository.save(notaCompra);
    }
    // Eliminar una nota de venta
    public void eliminarNotaCompra(Long id) {
        notaCompraRepository.deleteById(id);
    }
}
