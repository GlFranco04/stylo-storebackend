package com.stylo.store.models;

import java.util.Date;
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
@Table(name = "producto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "esta_activo")
    private boolean estaActivo;

    // Relación con DetalleProducto
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Esto evitará que se serialicen los detalles del producto cuando se haga un GET
    private Set<DetalleProducto> detallesProducto;

    // Relación con ProductoCategoria
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Esto también evita que se serialicen las categorías del producto
    private Set<ProductoCategoria> productoCategorias;

    // Constructor por defecto
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String nombre, String descripcion, Date fechaCreacion, boolean estaActivo) {
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public Set<ProductoCategoria> getProductoCategorias() {
        return productoCategorias;
    }

    public void setProductoCategorias(Set<ProductoCategoria> productoCategorias) {
        this.productoCategorias = productoCategorias;
    }
}
