package com.stylo.store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private double precio;

    // Relación ManyToOne con Producto, ignoramos la lista de DetalleProducto en Producto para evitar ciclo
    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonIgnoreProperties("detallesProducto")
    private Producto producto;

    // Relación ManyToOne con Talla, ignoramos la lista de DetalleProducto en Talla para evitar ciclo
    @ManyToOne
    @JoinColumn(name = "talla_id")
    @JsonIgnoreProperties("detallesProducto")
    private Talla talla;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }
}
