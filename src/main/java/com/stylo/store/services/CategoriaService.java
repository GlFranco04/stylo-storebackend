package com.stylo.store.services;

import com.stylo.store.models.Categoria;
import com.stylo.store.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías activas
    public List<Categoria> getAllActiveCategorias() {
        return categoriaRepository.findByEstaActivo(true);
    }

    // Obtener una categoría por ID
    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Cambiar el estado de una categoría (activar/desactivar)
    public void toggleCategoriaStatus(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            // Negar el estado actual de 'esta_activo'
            categoria.setEstaActivo(!categoria.isEstaActivo());
            categoriaRepository.save(categoria);  // Guardar los cambios
        }
    }
}
