package com.stylo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tallas")
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private boolean estaActivo = true;  // Por defecto, se considera que está activo al crearse

    // Constructor vacío (requerido por JPA)
    public Talla() {
    }

    // Constructor con parámetros
    public Talla(String nombre, boolean estaActivo) {
        this.nombre = nombre;
        this.estaActivo = estaActivo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
}
