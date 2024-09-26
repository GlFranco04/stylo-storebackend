package com.stylo.store.controllers;

import com.stylo.store.models.Talla;
import com.stylo.store.services.TallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/talla")
public class TallaController {

    @Autowired
    private TallaService tallaService;

    // Obtener todas las tallas activas
    @GetMapping
    public List<Talla> getAllTallas() {
        return tallaService.getAllTallas();
    }

    // Obtener una talla por ID
    @GetMapping("/{id}")
    public ResponseEntity<Talla> getTallaById(@PathVariable Long id) {
        Optional<Talla> talla = tallaService.getTallaById(id);
        return talla.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva talla
    @PostMapping
    public Talla createTalla(@RequestBody Talla talla) {
        return tallaService.saveTalla(talla);
    }

    // Actualizar una talla existente
    @PutMapping("/{id}")
    public ResponseEntity<Talla> updateTalla(@PathVariable Long id, @RequestBody Talla tallaDetails) {
        Optional<Talla> talla = tallaService.getTallaById(id);
        if (talla.isPresent()) {
            Talla updatedTalla = talla.get();
            updatedTalla.setNombre(tallaDetails.getNombre());
            updatedTalla.setEstaActivo(tallaDetails.isEstaActivo());
            return ResponseEntity.ok(tallaService.saveTalla(updatedTalla));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Alternar el estado de 'esta_activo' en una talla
    @PatchMapping("/{id}")
    public ResponseEntity<Void> toggleTallaStatus(@PathVariable Long id) {
        tallaService.toggleTallaStatus(id);
        return ResponseEntity.noContent().build();
    }
}
