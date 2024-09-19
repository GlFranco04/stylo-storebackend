package com.stylo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "producto_categoria")
public class ProductoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    // Constructor vacío
    public ProductoCategoria() {}

    // Constructor con parámetros
    public ProductoCategoria(Categoria categoria, Producto producto) {
        this.categoria = categoria;
        this.producto = producto;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
