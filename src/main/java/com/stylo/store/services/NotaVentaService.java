package com.stylo.store.services;

import com.stylo.store.models.NotaVenta;
import com.stylo.store.repositories.NotaVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaVentaService {

    @Autowired
    private NotaVentaRepository notaVentaRepository;

    // Obtener todas las notas de venta
    public List<NotaVenta> obtenerTodasLasNotasVenta() {
        return notaVentaRepository.findAll();
    }

    // Obtener una nota de venta por ID
    public Optional<NotaVenta> obtenerNotaVentaPorId(Long id) {
        return notaVentaRepository.findById(id);
    }

    // Crear o actualizar una nueva nota de venta
    public NotaVenta saveNotaVenta(NotaVenta notaVenta) {
        return notaVentaRepository.save(notaVenta);
    }
    // Eliminar una nota de venta
    public void eliminarNotaVenta(Long id) {
        notaVentaRepository.deleteById(id);
    }
}
