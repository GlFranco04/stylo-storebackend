package com.stylo.store.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
// tomar en cuenta que aquí no hay @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// solo está en la entidad "padre" o "Producto"
// por si acaso, ya no sé dónde es necesario poner eso, siempre que salga internal error puede ser una solución, hasta mientras no poner en ningun lado a no ser que sea necesario
@Table(name = "detalle_producto")
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private double precioCompra;
    private double precioVenta;

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

    // Relacion DetalleProducto con Inventario 1 a n
    @OneToMany(mappedBy = "detalleProducto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Inventario> inventarios;

    // Relacion DetalleProducto con ArchivoProducto 1 a n
    @OneToMany(mappedBy = "detalleProducto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ArchivoProducto> archivosProductos;

    // Relacion DetalleProducto con DetalleVenta 1 a n
    @OneToMany(mappedBy = "detalleProducto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<DetalleVenta> detalleVentas;

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

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
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

    public Set<Inventario> getInventarios(){
        return inventarios;
    }

    public void setInventarios(Set<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Set<ArchivoProducto> getArchivosProductos() {
        return archivosProductos;
    }
    
    public void setArchivosProductos(Set<ArchivoProducto> archivosProductos) {
        this.archivosProductos = archivosProductos;
    }

    public Set<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }
    
    public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
}
