package com.stylo.store.models;

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

import java.util.Set;

@Entity
@Table(name = "categoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "esta_activo")
    private boolean estaActivo;

    // Relación con ProductoCategoria
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Evitar que los productos de la categoría sean devueltos al hacer un GET de la categoría
    private Set<ProductoCategoria> productosCategoria;

    // Constructor por defecto
    public Categoria() {
    }

    // Constructor con parámetros
    public Categoria(String nombre, String descripcion, boolean estaActivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public Set<ProductoCategoria> getProductosCategoria() {
        return productosCategoria;
    }

    public void setProductosCategoria(Set<ProductoCategoria> productosCategoria) {
        this.productosCategoria = productosCategoria;
    }
}