package com.stylo.store.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "producto") // Define el nombre de la tabla en la BD
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID automáticamente
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "esta_activo")
    private boolean estaActivo;

    // // Relación con DetalleProducto (OneToMany)
    // @JsonManagedReference
    // @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<DetalleProducto> detalleProductos;

    // Constructor vacío para JPA
    public Producto() {}

    // Constructor con todos los parámetros
    public Producto(String nombre, String descripcion, LocalDate fechaCreacion, boolean estaActivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    // public Set<DetalleProducto> getDetalleProductos() {
    //     return detalleProductos;
    // }

    // public void setDetalleProductos(Set<DetalleProducto> detalleProductos) {
    //     this.detalleProductos = detalleProductos;
    // }
}
