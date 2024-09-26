package com.stylo.store.services;

import com.stylo.store.models.Talla;
import com.stylo.store.repositories.TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TallaService {

    @Autowired
    private TallaRepository tallaRepository;

    // Obtener todas las tallas activas
    public List<Talla> getAllTallas() {
        return tallaRepository.findAll();
    }

    // Obtener una talla por ID
    public Optional<Talla> getTallaById(Long id) {
        return tallaRepository.findById(id);
    }

    // Guardar o actualizar una talla
    public Talla saveTalla(Talla talla) {
        return tallaRepository.save(talla);
    }

    // Alternar el estado de 'esta_activo' en la talla
    public void toggleTallaStatus(Long id) {
        Optional<Talla> tallaOptional = tallaRepository.findById(id);
        if (tallaOptional.isPresent()) {
            Talla talla = tallaOptional.get();
            // Negar el estado actual de 'esta_activo'
            talla.setEstaActivo(!talla.isEstaActivo());
            tallaRepository.save(talla);  // Guardar los cambios
        }
    }
}
