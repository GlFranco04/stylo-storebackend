package com.stylo.store.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "talla")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "esta_activo")
    private boolean estaActivo;

    // Relación con DetalleProducto
    @OneToMany(mappedBy = "talla", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Esto evitará que los detalles del producto sean devueltos cuando se haga un GET de Talla
    private Set<DetalleProducto> detallesProducto;

    // Constructor por defecto
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

    public Set<DetalleProducto> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(Set<DetalleProducto> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }
}
