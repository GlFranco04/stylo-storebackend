package com.stylo.store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private boolean estaActivo;

    // Relación con DetalleProducto, ignoramos la propiedad "talla" para evitar el ciclo infinito
    @OneToMany(mappedBy = "talla", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("talla")
    private List<DetalleProducto> detallesProducto;

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

    public List<DetalleProducto> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(List<DetalleProducto> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }
}